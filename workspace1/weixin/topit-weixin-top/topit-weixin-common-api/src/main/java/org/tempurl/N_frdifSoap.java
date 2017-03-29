/**
 * N_frdifSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempurl;

public interface N_frdifSoap extends java.rmi.Remote {
    public short processdata(java.lang.String userid, java.lang.String password, java.lang.String cmdid, java.lang.String inputpara, javax.xml.rpc.holders.StringHolder outputpara, javax.xml.rpc.holders.IntHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException;
    public java.lang.String testconnect() throws java.rmi.RemoteException;
    public java.lang.String getversion() throws java.rmi.RemoteException;
    public short testconnectuser(java.lang.String userid, java.lang.String password, javax.xml.rpc.holders.IntHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException;
    public short getagentconfig(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, java.lang.String token, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg, javax.xml.rpc.holders.StringHolder configinfo) throws java.rmi.RemoteException;
    public short sendagentlog(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, java.lang.String token, java.lang.String loginfo, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException;
    public short checkagent(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg, javax.xml.rpc.holders.StringHolder lastdate, javax.xml.rpc.holders.StringHolder lasttoken) throws java.rmi.RemoteException;
}
