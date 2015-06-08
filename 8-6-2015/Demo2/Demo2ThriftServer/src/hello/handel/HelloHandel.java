/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.handel;

import com.example.project.TwitterUnavailable;
import hello.thrift.HelloService;
import hello.thrift.Tweet;
import org.apache.thrift.TException;

/**
 *
 * @author HoaiBao
 */
public class HelloHandel implements HelloService.Iface{

    @Override
    public Tweet KhoiTao() throws TException {
       Tweet t = new Tweet();

       
       return t;
    }

    @Override
    public com.example.project.Tweet getBaseTweet() throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tweet getChildTweet() throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ping() throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean postTweet(com.example.project.Tweet tweet) throws TwitterUnavailable, TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int searchTweets(String query) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zip() throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
