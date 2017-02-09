var app = getApp()
Page({
  data: {
      branchName:"",
      title:"",
      address:"",
  },
  onLoad: function (obj) {
    console.log(obj)
    var that = this
    that.setData({
        title:obj.title,
        brandName:obj.brandName,
        address:obj.address
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