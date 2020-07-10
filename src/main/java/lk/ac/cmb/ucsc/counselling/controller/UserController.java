package lk.ac.cmb.ucsc.counselling.controller;

import lk.ac.cmb.ucsc.counselling.dto.*;
import lk.ac.cmb.ucsc.counselling.model.*;
import lk.ac.cmb.ucsc.counselling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RequestMapping("api/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private  UserService userService;



    private Boolean value=false;

    @PostMapping(path = "/counselorrequest", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void addRequest(@RequestBody @Valid @NonNull Request request) {

        System.out.println("came to the server");
        System.out.println(request.getUser_id());
        System.out.println(request.getUser_name());
        System.out.println(request.getDoctor_name());
    }
    @GetMapping(path = "/getCounselors", produces = "application/json")
    @CrossOrigin
    public List<Counselor> getCounselors() {
        System.out.println("Get counselors");
        return userService.getCounselors();
    }

    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public List<User> signIn(@RequestBody @Valid @NonNull Password password) {

        System.out.println("came to the server");
        System.out.println(password.getEmail()+" email");
        value=true;
        try{
//            if(userService.signIn(password)){
//                return ResponseEntity.ok(true);
//            }else{
//                return ResponseEntity.ok(false);
//            }
            return userService.signIn(password);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(path = "/quicksignup", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> quickSignUp(@RequestBody  User user) {

        System.out.println("came to the server");
        try{
            if(userService.quickSignUp(user)){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }
    @PostMapping(path = "/formalsignup", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> formalSignUp(@RequestBody User user) {

        System.out.println("came to the server");
        try{
            if(userService.formalSignUp(user)){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping(path = "/requestcounselor", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> requestCounselor(@RequestBody @Valid @NonNull CounselorRequestDTO counselorRequest) {
        System.out.println("came to the server");
        try{
            return userService.requestCounselor(counselorRequest);

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping(path = "/newpost", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Post addPost(@RequestBody @Valid @NonNull PostDTO post) {

        System.out.println("came to the server");
        System.out.println(post.getPost_description());

        try{
            return userService.addPost(post);

        }catch(Exception e){
            e.printStackTrace();
            return new Post();
        }
    }
    @PostMapping(path = "/addcomment", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Post addCommentToPost(@RequestBody @Valid @NonNull CommentDTO comment) {

        System.out.println("came to the server");
        System.out.println(comment.getComment_description());
        System.out.println(comment.getPost_id());
        try{
            return userService.addCommentToPost(comment);

        }catch(Exception e){
            e.printStackTrace();
            return new Post();
        }
    }
    @GetMapping(path = "/getposts", produces = "application/json")
    @CrossOrigin
    public List<Post> getPosts() {
        System.out.println("Get counselors");
        return userService.getPosts();
    }

    @PostMapping(path = "/verifyaccount/{email}", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void verifyAccount(@PathVariable("email") String email) {
        System.out.println(email);
        userService.verifyAccount(email);


    }
    @GetMapping(path = "/getuser/{uid}" ,produces = "application/json")
    @CrossOrigin
    public User getUser(@PathVariable("uid")long id) {
        System.out.println("Get counselors");
        return userService.getUser(id);
    }

    @PostMapping(path = "/updateuser", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);

    }
    @PostMapping(path = "/changepassword", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Password changePassword(@RequestBody PasswordChangeDTO pw) {

        return userService.changePassword(pw);

    }
    @GetMapping(path = "/getrequests", produces = "application/json")
    @CrossOrigin
    public List<AppointmentRequest> getRequests() {
        System.out.println("Get counselors");
        return userService.getRequests();
    }

    @GetMapping(path = "/getrated", produces = "application/json")
    @CrossOrigin
    public List<Rated> getRated() {
        System.out.println("Get rated");
        return userService.getRated();
    }
    @PostMapping(path = "/ratecounselor", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Counselor rateCounselor(@RequestBody RateDTO rate) {
        System.out.println("rate");
        return userService.rateCounselor(rate);

    }

    @GetMapping(path = "/getpayment", produces = "application/json")
    @CrossOrigin
    public List<Payment> getPayment() {
        System.out.println("Get rated");
        return userService.getPayment();
    }
    @PostMapping(path = "/updatepayment",consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Payment updatePayment(@RequestBody RateDTO payment) {
        System.out.println("Get rated");
        return userService.updatePayment(payment);
    }



}
