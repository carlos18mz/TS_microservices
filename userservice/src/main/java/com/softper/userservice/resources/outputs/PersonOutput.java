package com.softper.userservice.resources.outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonOutput {
    private String firstName;
    private String lastName;
    private String email;
    private String userType;
}
