//main.js
//获取应用实例
var app = getApp()
Page({
  data: {
      latitude:0,
      longitude:0,
      btnname:"定位中请稍后...",
      loading:true,
      disabled:true,
      markers:[],
      brand:"",
      pics:[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],
      brands:["NK","AD","AS","AO","AK","PU","CV","VN","TB","NF","CB","AC","OT","UG","RB","MT"],
      left:0
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
    
    that.getlocation();
    
  },
  //获取定位信息
  getlocation:function(){
      var that = this
      that.setData({
            btnname:"定位中请稍后...",
            loading:true,
            disabled:true
        })
      wx.getLocation({
      type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
      success: function(res){
        // success
        that.setData({
            latitude:res.latitude,
            longitude:res.longitude,
            btnname:"刷新定位",
            loading:false,
            disabled:false
        });
        that.getbranches();
      },
      fail: function() {
        // fail
        that.setData({
            btnname:"定位失败，点此重试",
            loading:false,
            disabled:false
        })
      },
      complete: function() {
        // complete
      }
    })
  },
  brandclick:function(res){
    var that = this
    console.log(res.currentTarget.id);
    // if(that.data.brand == res.currentTarget.id){
    //   that.setData({
    //     brand:""
    //   })
    // }else{
      var num = res.currentTarget.id;
      var picss = that.data.pics;
      var brands = that.data.brand;
      if(num.indexOf("a")==-1){
        picss[num-1]=num+"a";
        brands+=that.data.brands[num-1]+":";
      }else{
        num = num.replace("a","");
        picss[num-1]=num;
        brands = brands.replace(that.data.brands[num-1]+":","");
      }
      console.log("lalalal:"+brands)
      num = num.replace("a","");
      that.setData({
        brand:brands,
        pics:picss
      })
    //}
    that.getbranches();
  },
  getbranches:function(){
    var that = this
    //查找店铺
    wx.request({
      url: 'https://twx2.topsports.com.cn/topit-weixin-web/mobile/sign/getbranchs?latitude='+that.data.latitude+"&longitude="+that.data.longitude+"&brand="+that.data.brand,
      data: {},
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        // success
        console.log(res);
        wx.setStorage({
          key: 'lists',
          data: res.data
        })
        that.setData({
            markers:res.data
        })
      }
    })
  },
  //店铺点击事件
  markertap(e) {
    var lists = wx.getStorageSync('lists');
    for(var i=0;i<lists.length;i++){
      if(lists[i].id==e.markerId){
        wx.showModal({
          title: lists[i].title,
          content:lists[i].address,
          showCancel:false
        })
        return;
      }
    }
  },
  //更多
  moreclick(e){
    var that = this
    if(that.data.left>=900){
      that.setData({
        left:0
      })
    }else{
      that.setData({
      left:that.data.left+300
    })
    }
    
  }
})
