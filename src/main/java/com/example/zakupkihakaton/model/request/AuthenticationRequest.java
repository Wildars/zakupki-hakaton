package com.example.zakupkihakaton.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    @NotBlank
    @ApiModelProperty(example = "10101000100000", notes = "ПИН")
    @Size(min = 14, max = 14)
    @Pattern(regexp = "^[0-9]+$", message = "ПИН должен состоять только из цифр")
    String pin;

    @NotBlank
    String password;
}
