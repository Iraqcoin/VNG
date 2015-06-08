/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2thriftserver;

import hello.handel.HelloHandel;
import hello.thrift.HelloService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author HoaiBao
 */
public class Demo2ThriftServer {

    /**
     * @param args the command line arguments
     */
    public static HelloHandel handler;
    public static HelloService.Processor processor;

    public static void main(String[] args) {
        handler = new HelloHandel();
        processor = new HelloService.Processor(handler);
        Runnable simple = new Runnable() {
            @Override
            public void run() {
                simple(processor);
            }
        };
        Runnable sercure = new Runnable() {
            @Override
            public void run() {
                secure(processor);
            }
        };
        new Thread(simple).start();
        new Thread(sercure).start();
    }

    public static void simple(HelloService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException ex) {
            Logger.getLogger(Demo2ThriftServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void secure(HelloService.Processor processor) {
        try {
            TSSLTransportParameters params = new TSSLTransportParameters();
            params.setKeyStore("../test/.keystore", "thrift", null, null);
            TServerTransport serverTransport = TSSLTransportFactory.getServerSocket(9091, 0, null, params);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the secure server...");
            server.serve();
        } catch (TTransportException ex) {
            Logger.getLogger(Demo2ThriftServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
