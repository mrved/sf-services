package com.thefallenbrain.stayfithub.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason ="Email already in use")
public class InvalidMemberDetailException extends Exception {
}
