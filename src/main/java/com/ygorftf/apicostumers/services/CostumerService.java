package com.ygorftf.apicostumers.services;

import com.ygorftf.apicostumers.dto.AddressDTO;
import com.ygorftf.apicostumers.dto.CostumerDTO;
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

import java.util.List;
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
    public CostumerDTO findCostumerById(Long id) {
        Optional<Costumer> costumer = repository.findById(id);
        return new CostumerDTO(costumer);
    }

    @Transactional(readOnly = true)
    public Page<CostumerDTO> findAllCostumers(Pageable pageable, String name) {
        Page<Costumer> page = repository.findAllCostumers(pageable, name);
        return page.map(x -> new CostumerDTO(x));
    }

    @Transactional
    public CostumerDTO updateCostumerById(Long id, CostumerDTO dto) {
        Costumer costumer = repository.getReferenceById(id);
        costumer.setName(dto.getName());

        for (AddressDTO aDto : dto.getAddresses()) {
            Address a = addressRepository.getReferenceById(aDto.getId());
            a.setStreet(aDto.getStreet());
            a.setNumber(aDto.getNumber());
            a.setDistrict(aDto.getDistrict());
            a.setCity(aDto.getCity());
            a.setAddressLink(aDto.getAddressLink());
            addressRepository.save(a);
            costumer.getAddresses().add(a);
        }

        for (PhoneDTO pDto : dto.getPhoneNumbers()){
            Phone p = phoneRepository.getReferenceById(pDto.getId());
            p.setPhoneNumber(pDto.getPhoneNumber());
            phoneRepository.save(p);
            costumer.getPhoneNumbers().add(p);
        }

        costumer = repository.save(costumer);
        return new CostumerDTO(costumer);
    }

   /* public AddressDTO updateCostumerById(Long id, AddressDTO dto) {
        Address address = addressRepository.getReferenceById(id);

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setDistrict(dto.getDistrict());
        address.setCity(dto.getCity());
        address.setAddressLink(dto.getAddressLink());

        address = addressRepository.save(address);
        return new AddressDTO(address);
    }

    */
}
