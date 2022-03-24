package com.semihshn.passengerservice.adapter.rest.contactInfo;

import com.semihshn.passengerservice.adapter.rest.contactInfo.request.ContactInfoCreateRequest;
import com.semihshn.passengerservice.adapter.rest.contactInfo.response.ContactInfoCreateResponse;
import com.semihshn.passengerservice.adapter.rest.contactInfo.response.ContactInformationResponse;
import com.semihshn.passengerservice.domain.contactInfo.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contactinformations")
public class ContactInfoController {

    private final ContactInfoService contactInformationService;

    @PostMapping()
    public ContactInfoCreateResponse create(@RequestBody @Valid ContactInfoCreateRequest request) {
        Long createdContactId = contactInformationService.create(request.convertToContactInformation());
        return ContactInfoCreateResponse.builder().id(createdContactId).build();
    }

    @GetMapping("{contactId}")
    public ContactInformationResponse retrieve(@PathVariable Long contactId) {
        return ContactInformationResponse.from(contactInformationService.retrieve(contactId));
    }
}
