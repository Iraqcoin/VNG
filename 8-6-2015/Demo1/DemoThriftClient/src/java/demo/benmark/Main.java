/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.benmark;

import Common.ThriftInterface.User;
import Common.ThriftInterface.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 *
 * @author HoaiBao
 */
public class Main {

    public static long tong = 0;

    public static void main(String[] argv) throws InterruptedException {
        //N = 10 ; số Thread;
        //n = 1000 ; số request của 1 Thread     
        List<Thread> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            Runnable run = new Runnable() {
                public void run() {

                    TTransport transport = null;
                    UserService.Client client = null;
                    try {
                        transport = new TFramedTransport(new TSocket("localhost", 9090));//Nonlocking Server
                        //transport = new TSocket("localhost", 9090);
                        transport.open();
                        TProtocol protocol = new TBinaryProtocol(transport);
                        client = new UserService.Client(
                                protocol);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    for (int j = 1; j <= 1000; j++) {
                        try {
                           User u = client.GetUser(Thread.currentThread().getName());
                            //client.UpdateVisitor(Thread.currentThread().getName());
                            System.out.println(Thread.currentThread().getName() + " : " + j + " __ username : ");
                        } catch (TException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    transport.close();
                }
            };
            Thread t = new Thread(run);
            list.add(t);
            t.setName("Thread " + i);
            t.start();
        }
        // chờ cho đến khi chạy hết 10 thread.
        while (true) {
            try {
                for (Thread t : list) {
                    t.join();
                }
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        tong = end - start;
        System.out.println(tong);
        float tb = 10000.0f / ((float) tong / 1000f);
        System.out.println(tb + " ");

    }
}
