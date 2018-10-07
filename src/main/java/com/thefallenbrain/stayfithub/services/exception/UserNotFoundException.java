package com.thefallenbrain.stayfithub.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.OK, reason = "Invalid username or password")
public class UserNotFoundException extends Exception {
}
