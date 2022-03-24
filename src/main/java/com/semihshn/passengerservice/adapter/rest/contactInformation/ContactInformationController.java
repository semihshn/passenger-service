package com.semihshn.passengerservice.adapter.rest.contactInformation;

import com.semihshn.passengerservice.adapter.rest.contactInformation.request.ContactInformationCreateRequest;
import com.semihshn.passengerservice.adapter.rest.contactInformation.response.ContactInformationCreateResponse;
import com.semihshn.passengerservice.adapter.rest.contactInformation.response.ContactInformationResponse;
import com.semihshn.passengerservice.domain.contactInformation.ContactInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contactinformations")
public class ContactInformationController {

    private final ContactInformationService contactInformationService;

    @PostMapping()
    public ContactInformationCreateResponse create(@RequestBody @Valid ContactInformationCreateRequest request) {
        Long createdContactId = contactInformationService.create(request.convertToContactInformation());
        return ContactInformationCreateResponse.builder().id(createdContactId).build();
    }

    @GetMapping("{contactId}")
    public ContactInformationResponse retrieve(@PathVariable Long contactId) {
        return ContactInformationResponse.from(contactInformationService.retrieve(contactId));
    }
}
