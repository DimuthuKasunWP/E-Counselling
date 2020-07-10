package lk.ac.cmb.ucsc.counselling.service;



import lk.ac.cmb.ucsc.counselling.dto.CommentDTO;
import lk.ac.cmb.ucsc.counselling.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.counselling.dto.PasswordChangeDTO;
import lk.ac.cmb.ucsc.counselling.dto.PostDTO;
import lk.ac.cmb.ucsc.counselling.dto.*;
import lk.ac.cmb.ucsc.counselling.model.*;
import lk.ac.cmb.ucsc.counselling.model.Counselor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class UserService {


    private String link="http://localhost:3000/user/verifyaccount";

    public Post addPost(PostDTO postdto) {

        return null;

    }
    public void addRequest(Request request){

    }

    public List<User> signIn(Password password) {
       return null;
    }

    public boolean quickSignUp(User user) {
       return false;
    }

    //can use this later when the user decides to  fill in the formal data
    public boolean formalSignUp(User user) {
       return false;


    }

    public List<Counselor> getCounselors() {
      return null;
    }

    public List<User> getUsers(){
       return null;
    }

    public ResponseEntity<Boolean> requestCounselor(@Valid CounselorRequestDTO counselorRequest) {
        return null;
    }

    public List<Post> getPosts() {
      return null;
    }

    public Post addCommentToPost(CommentDTO commentdto) {
        return null;

    }

    public String calculateDateDifference(Date old){
      return "";
    }

    public void verifyAccount(String email) {

    }

    public User getUser(long id) {
        return null;
    }

    public User updateUser(User user) {
       return null;
    }

    public Password changePassword(PasswordChangeDTO pw) {
       return null;
    }

    public List<AppointmentRequest> getRequests() {
        return null;
    }

    public List<Rated> getRated() {
        return null;
    }

    public Counselor rateCounselor(RateDTO rate) {
       return null;
    }

    public List<Payment> getPayment() {
        return null;
    }

    public Payment updatePayment(RateDTO payment) {
      return null;
    }
}
