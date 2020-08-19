package com.digifreneur.foodaway.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping("/api")
@Api(value="foodaway-application", description="Operations pertaining to user login and logout in the Foodaway application")
public class FakeController {
    
    @ApiOperation("Login")
    @PostMapping("/auth")
    public void fakeLogin(@RequestBody @Valid LoginRequest loginRequest) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by System Security filters.");
    }

    @ApiOperation("Logout")
    @PostMapping("/logout")
    public void fakeLogout() {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by System Security filters.");
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class LoginRequest{
        @NotNull(message = "{constraints.NotEmpty.message}")
        private String email;
        @NotNull(message = "{constraints.NotEmpty.message}")
        private String password;
    }
}