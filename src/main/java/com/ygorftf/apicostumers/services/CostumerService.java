package com.ygorftf.apicostumers.services;

import com.ygorftf.apicostumers.dto.AddressDTO;
import com.ygorftf.apicostumers.dto.CostumerAddressPhoneDTO;
import com.ygorftf.apicostumers.dto.PhoneDTO;
import com.ygorftf.apicostumers.entities.Address;
import com.ygorftf.apicostumers.entities.Costumer;
import com.ygorftf.apicostumers.entities.Phone;
import com.ygorftf.apicostumers.repositories.AddressRepository;
import com.ygorftf.apicostumers.repositories.CostumerRepository;
import com.ygorftf.apicostumers.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository repository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Transactional(readOnly = true)
    public CostumerAddressPhoneDTO findCostumerById(Long id) {
        Optional<Costumer> costumer = repository.findById(id);
        return new CostumerAddressPhoneDTO(costumer);
    }

    @Transactional(readOnly = true)
    public Page<CostumerAddressPhoneDTO> findAllCostumers(Pageable pageable, String name) {
        Page<Costumer> page = repository.findAllCostumers(pageable, name);
        return page.map(x -> new CostumerAddressPhoneDTO(x));
    }

    @Transactional
    public CostumerAddressPhoneDTO insertCostumer(CostumerAddressPhoneDTO dto) {
        Costumer costumer = new Costumer();
        costumer.setName(dto.getName());

        for (AddressDTO aDto : dto.getAddresses()) {
            Address address = new Address();
            address.setStreet(aDto.getStreet());
            address.setNumber(aDto.getNumber());
            address.setDistrict(aDto.getDistrict());
            address.setCity(aDto.getCity());
            address.setAddressLink(aDto.getAddressLink());
            address.setCostumer(costumer);
            costumer.getAddresses().add(address);
            addressRepository.save(address);
        }

        for (PhoneDTO pDto : dto.getPhoneNumbers()) {
            Phone phone = new Phone();
            phone.setPhoneNumber(pDto.getPhoneNumber());
            phone.setCostumer(costumer);
            costumer.getPhoneNumbers().add(phone);
            phoneRepository.save(phone);
        }

        repository.save(costumer);
        return new CostumerAddressPhoneDTO(costumer);
    }

    @Transactional
    public CostumerAddressPhoneDTO updateCostumer(Long id, CostumerAddressPhoneDTO dto) {
        Costumer costumer = repository.getReferenceById(id);
        costumer.setName(dto.getName());

        for (AddressDTO aDto : dto.getAddresses()) {
            Address address = addressRepository.getReferenceById(aDto.getId());
            copyAddressToDto(address, aDto);
            addressRepository.save(address);
            costumer.getAddresses().add(address);
        }

        for (PhoneDTO pDto : dto.getPhoneNumbers()) {
            Phone phone = phoneRepository.getReferenceById(pDto.getId());
            phone.setPhoneNumber(pDto.getPhoneNumber());
            phoneRepository.save(phone);
            costumer.getPhoneNumbers().add(phone);
        }

        costumer = repository.save(costumer);
        return new CostumerAddressPhoneDTO(costumer);
    }
        public void copyAddressToDto(Address address, AddressDTO dto) {
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setDistrict(dto.getDistrict());
        address.setCity(dto.getCity());
        address.setAddressLink(dto.getAddressLink());
    }
}
