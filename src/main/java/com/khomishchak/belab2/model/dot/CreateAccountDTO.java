package com.khomishchak.belab2.model.dot;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountDTO {

    @NotNull(message = "User ID is required")
    private Long userId;

    @Min(value = 0, message = "Initial balance cannot be negative")
    private double initialBalance;
}