var app = getApp()
Page({
  data: {
      branchName:"",
      title:"",
      address:"",
      products:[],
      branchCode:"",
      message:"",
      message1:"点击查看库存",
      showModelStatus:false,
      currentindex:0,
      sizes:[],
      storeNumber:""
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
          url: app.globalData.linkHead+'mobile/sign/getprosal?branchCode='+obj.branchCode,
          data: {},
          method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
          // header: {}, // 设置请求的 header
          success: function(res){
            // success
            console.log(res.data);
            if(res.data.length==0){
              that.setData({
                message:"该店铺暂无热销记录",
                message1:""
              })
            }else{
              that.setData({
                message:"",
                products:res.data,
                message1:"点击查看库存"
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
  },
  showimage:function(e){
    // if(e.currentTarget.id=='../../images/nopic.png'){
    //   return;
    // }
    // var that = this
    // var data =  that.data.products;
    // var srcs = [];
    // var j = 0;
    // for(var i=0;i<data.length;i++){
    //   var src = data[i].url;
    //   console.log(data);
    //   if(src!='../../images/nopic.png'){
    //       srcs[j]=src;j++;
    //   }
    // }
    // wx.previewImage({
    //    current: e.currentTarget.id, // 当前显示图片的链接，不填则默认为 urls 的第一张
    //   urls: srcs,
    //   success: function(res){
    //     // success
    //   },
    //   fail: function() {
    //     // fail
    //   },
    //   complete: function() {
    //     // complete
    //   }
    // })
    console.log(e);
    var that = this
    //获取尺码信息
    that.getsizes(e.currentTarget.id);    
    
  },
   hideModel(){
    var that = this
    that.setData({
      showModelStatus:false
    })
  },
  //获取尺码信息
  getsizes(index){
    var that = this
    var products = that.data.products;
    wx.request({
      url: app.globalData.linkHead+'mobile/sign/selectsizes?branchCode='+products[index].organ_new_no+'&productCode='+products[index].product_code,
      data: {},
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        // success
        var stornumber = "";
        var data = res.data;
        if(data!=null&&data.length>0){
          stornumber = data[0].inv_qty;
        }
        that.setData({
          showModelStatus:true,
          currentindex:index,
          sizes:res.data,
          storeNumber:stornumber
        })
      },
      fail: function() {
        // fail
        that.setData({
          showModelStatus:true,
          currentindex:index
        })
      },
      complete: function() {
        // complete
      }
    })
  },
  sizetap(e){
    console.log(e);
    var that = this
    var index = e.currentTarget.id;
    var sizes=that.data.sizes;
    for(var i=0;i<sizes.length;i++){
      sizes[i].url="http://aaa/aa";
    }
    sizes[index].url="../../images/on.png";
    that.setData({
      sizes:sizes,
      storeNumber:sizes[index].inv_qty
    })
  },
  swperchange(e){
    var that = this
    var index = e.detail.current;
    that.getsizes(index);

  }
})