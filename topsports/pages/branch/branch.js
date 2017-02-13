var app = getApp()
Page({
  data: {
      branchName:"",
      title:"",
      address:"",
      products:[],
      branchCode:"",
      message:""
  },
  onLoad: function (obj) {
    console.log(obj)
    var that = this
    that.setData({
        title:obj.title,
        brandName:obj.brandName,
        address:obj.address,
        branchCode:obj.branchCode
    })
    //请求热销数据
        wx.request({
          url: 'https://twx2.topsports.com.cn/topit-weixin-web/mobile/sign/getprosal?branchCode='+obj.branchCode,
          data: {},
          method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
          // header: {}, // 设置请求的 header
          success: function(res){
            // success
            console.log(res.data);
            if(res.data.length==0){
              that.setData({
                message:"该店铺暂无热销记录"
              })
            }else{
              that.setData({
                message:"",
                products:res.data
              })
            }
          },
          fail: function() {
            // fail
          },
          complete: function() {
            // complete
          }
        })
  },
  goback:function(){
      wx.navigateBack({
        delta: 1, // 回退前 delta(默认为1) 页面
        success: function(res){
          // success
        },
        fail: function() {
          // fail
        },
        complete: function() {
          // complete
        }
      })
  }
})