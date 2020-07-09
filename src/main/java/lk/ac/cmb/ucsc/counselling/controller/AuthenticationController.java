package lk.ac.cmb.ucsc.counselling.controller;


import lk.ac.cmb.ucsc.counselling.model.LoginCredentials;
import lk.ac.cmb.ucsc.counselling.service.LoginService;
import lk.ac.cmb.ucsc.counselling.util.ActiveUsers;
import lk.ac.cmb.ucsc.counselling.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RequestMapping("authenticate")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ActiveUsers activeUsersUtil;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginCredentials credentials) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }

        final UserDetails userDetails = loginService.loadUserByUsername(credentials.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

//        Crazy hack to maintain Logged users. Not suitable in production env
        activeUsersUtil.add(userDetails.getUsername());

        Map<String,String> jwtMap=new HashMap<>(1);
        jwtMap.put("jwt",jwt);

        return ResponseEntity.ok(jwtMap);
    }
}
