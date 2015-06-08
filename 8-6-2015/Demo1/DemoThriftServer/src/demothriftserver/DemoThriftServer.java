/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothriftserver;

import Common.Provider.UserHandler;
import Common.ThriftInterface.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author HoaiBao
 */
public class DemoThriftServer {

    public static UserHandler handler;

    public static UserService.Processor processor;

    public static void main(String[] args) {

        try {
            UserHandler calc = new UserHandler();
            UserService.Processor processor = new UserService.Processor(calc);
           //TSimpleServer_Benmark(processor);
            TThreadPoolServer_Benmark(processor);
           //TNonblockingServer_Benmark(processor);
            //THsHaServer_Benmark(processor);
            //TThreadedSelectorServer_Benmark(processor);
        } catch (TTransportException e) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private static void TNonblockingServer_Benmark(UserService.Processor processor) throws TTransportException {
        //Nonlocking Server
        TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
        TNonblockingServer.Args args1 = new TNonblockingServer.Args(serverTransport);
        args1.processor(processor);
        args1.transportFactory(new TFramedTransport.Factory());
        args1.protocolFactory(new TBinaryProtocol.Factory(true, true));
        TServer server = new TNonblockingServer(args1);
        System.out.println("Started service successfully...");
        server.serve();
    }

    private static void TSimpleServer_Benmark(UserService.Processor processor) throws TTransportException {
        TServerSocket serverTransport = new TServerSocket(9090);
        Args args1 = new Args(serverTransport);
        args1.processor(processor);
        TServer server = new TSimpleServer(args1);
        System.out.println("Started service successfully...");
        server.serve();
    }

    private static void TThreadPoolServer_Benmark(UserService.Processor processor) throws TTransportException {
        TServerSocket serverTransport = new TServerSocket(9090);
        Args args1 = new Args(serverTransport);
        args1.processor(processor);
        TServer server = new TThreadPoolServer(args1);
        System.out.println("Started service successfully...");
        server.serve();
    }

    private static void TThreadedSelectorServer_Benmark(UserService.Processor processor) throws TTransportException {
        TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9090);
        TServer server = new TThreadedSelectorServer(new TThreadedSelectorServer.Args(serverTransport).processor(processor));
        System.out.println("Started service successfully...");
        server.serve();
    }

    private static void THsHaServer_Benmark(UserService.Processor processor) throws TTransportException {
        TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9090);
        THsHaServer.Args args1 = new THsHaServer.Args(serverTransport);
        args1.processor(processor);
        TServer server = new THsHaServer(args1);
        System.out.println("Started service successfully...");
        server.serve();
    }
}
