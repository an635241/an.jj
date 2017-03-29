package org.tempurl;

public class N_frdifSoapProxy implements org.tempurl.N_frdifSoap {
  private String _endpoint = null;
  private org.tempurl.N_frdifSoap n_frdifSoap = null;
  
  public N_frdifSoapProxy() {
    _initN_frdifSoapProxy();
  }
  
  public N_frdifSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initN_frdifSoapProxy();
  }
  
  private void _initN_frdifSoapProxy() {
    try {
      n_frdifSoap = (new org.tempurl.N_frdifLocator()).getn_frdifSoap();
      if (n_frdifSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)n_frdifSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)n_frdifSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (n_frdifSoap != null)
      ((javax.xml.rpc.Stub)n_frdifSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempurl.N_frdifSoap getN_frdifSoap() {
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap;
  }
  
  public short processdata(java.lang.String userid, java.lang.String password, java.lang.String cmdid, java.lang.String inputpara, javax.xml.rpc.holders.StringHolder outputpara, javax.xml.rpc.holders.IntHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.processdata(userid, password, cmdid, inputpara, outputpara, rtn, errormsg);
  }
  
  public java.lang.String testconnect() throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.testconnect();
  }
  
  public java.lang.String getversion() throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.getversion();
  }
  
  public short testconnectuser(java.lang.String userid, java.lang.String password, javax.xml.rpc.holders.IntHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.testconnectuser(userid, password, rtn, errormsg);
  }
  
  public short getagentconfig(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, java.lang.String token, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg, javax.xml.rpc.holders.StringHolder configinfo) throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.getagentconfig(userid, password, storeid, agentid, token, rtn, errormsg, configinfo);
  }
  
  public short sendagentlog(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, java.lang.String token, java.lang.String loginfo, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg) throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.sendagentlog(userid, password, storeid, agentid, token, loginfo, rtn, errormsg);
  }
  
  public short checkagent(java.lang.String userid, java.lang.String password, java.lang.String storeid, java.lang.String agentid, javax.xml.rpc.holders.ShortHolder rtn, javax.xml.rpc.holders.StringHolder errormsg, javax.xml.rpc.holders.StringHolder lastdate, javax.xml.rpc.holders.StringHolder lasttoken) throws java.rmi.RemoteException{
    if (n_frdifSoap == null)
      _initN_frdifSoapProxy();
    return n_frdifSoap.checkagent(userid, password, storeid, agentid, rtn, errormsg, lastdate, lasttoken);
  }
  
  
}