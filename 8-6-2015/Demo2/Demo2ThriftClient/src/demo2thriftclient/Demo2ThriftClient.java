/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2thriftclient;

import hello.thrift.HelloService;
import hello.thrift.Tweet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 *
 * @author HoaiBao
 */
public class Demo2ThriftClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        args = new String[1];
        args[0] = scan.nextLine();
        if (args.length != 1) {
            System.out.println("Please enter 'simple' or 'secure'");
            System.exit(0);
        }
        try {
            TTransport transport;
            if (args[0].contains("simple")) {
                transport = new TSocket("localhost", 9090);
                transport.open();
            }
            else
            {
                 TSSLTransportParameters params = new TSSLTransportParameters();
                params.setTrustStore("../test/.truststore", "thrift", "SunX509", "JKS");
                transport = TSSLTransportFactory.getClientSocket("localhost", 9091, 0, params);
            }
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            perform(client);
            transport.close();
        } catch (Exception ex) {
                ex.printStackTrace();
        }

    }

    private static void perform(HelloService.Client client) {
        try {
            Tweet t = client.KhoiTao();
            System.out.println(t.getUserId());
            System.out.println(t.getLoc());
             System.out.println(t.getTweetType());
            
        } catch (TException ex) {
            Logger.getLogger(Demo2ThriftClient.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
