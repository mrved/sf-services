package com.thefallenbrain.stayfithub.services.controller.security;

import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;


public interface User extends UserDetails, Serializable {

}
