webpackJsonp([1],{"/YRK":function(e,o){},"72TY":function(e,o){},"9n10":function(e,o){},AOyH:function(e,o){},Hsgg:function(e,o){},M6Sr:function(e,o){},NHnr:function(e,o,t){"use strict";Object.defineProperty(o,"__esModule",{value:!0});var n=t("7+uW"),a={render:function(){var e=this.$createElement,o=this._self._c||e;return o("keep-alive",{attrs:{exclude:"Detail"}},[o("router-view")],1)},staticRenderFns:[]};var r=t("VU/8")({name:"App"},a,!1,function(e){t("Yr2x")},null,null).exports,s=t("/ocq"),i=t("mtWM"),l=t.n(i);function c(e){return"http://localhost:80/"+e}var h={name:"Login",data:function(){return{userName:"",password:"",errorInfo:""}},methods:{submit:function(){var e=this,o=c("login");console.log(o),""!=this.userName.trim()?""!=this.password.trim()?(console.log("ok"),l.a.post(o,{userName:this.userName,password:this.password}).then(function(o){0==o.data.code?(window.localStorage.setItem("token",o.data.token),e.$router.replace("/phoneBook")):e.errorInfo=o.data.msg}).catch(function(o){console.log(o),e.errorInfo=o})):this.errorInfo="密码不能为空！":this.errorInfo="用户名不能为空！"}}},d={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",[t("div",{staticClass:"login-logo"},[e._v("通讯录")]),e._v(" "),t("form",{staticClass:"login-cont",attrs:{action:""}},[t("ul",[t("li",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userName,expression:"userName"}],attrs:{type:"text",placeholder:"请输入用户名："},domProps:{value:e.userName},on:{input:function(o){o.target.composing||(e.userName=o.target.value)}}})]),e._v(" "),t("li",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password",placeholder:"请输入密码："},domProps:{value:e.password},on:{input:function(o){o.target.composing||(e.password=o.target.value)}}})])]),e._v(" "),t("a",{staticClass:"submitButton",attrs:{href:"javascript:;"},on:{click:function(o){return e.submit()}}},[e._v("登  录")]),e._v(" "),t("p",{staticClass:"errorInfo"},[e._v(e._s(e.errorInfo))])]),e._v(" "),e._m(0)])},staticRenderFns:[function(){var e=this.$createElement,o=this._self._c||e;return o("p",{staticClass:"copyright"},[this._v("\n    Copyright © 2012-2019 "),o("a",{attrs:{href:"http://www.java1234.com"}},[this._v("www.java1234.com")])])}]};var m=t("VU/8")(h,d,!1,function(e){t("TVuH")},"data-v-620f28b6",null).exports,u=t("x9pK"),p=t.n(u),v={render:function(){var e=this.$createElement,o=this._self._c||e;return o("div",{staticClass:"header"},[this._v("\n  通讯录\n  "),o("router-link",{staticClass:"iconfont add-icon",attrs:{tag:"div",to:"/add"}},[this._v("")])],1)},staticRenderFns:[]};var k=t("VU/8")({name:"Header"},v,!1,function(e){t("AOyH")},"data-v-90ee42d6",null).exports,f=t("GQaK"),g={name:"Search",data:function(){return{keyword:"",list:[]}},methods:{getImageUrl:function(e){return c("image/"+e)}},props:{phoneBooks:Object},watch:{keyword:function(){var e=this;if(this.keyword){var o=[];for(var t in this.phoneBooks)this.phoneBooks[t].forEach(function(t){t.name.indexOf(e.keyword)>-1&&o.push(t)});this.list=o}else this.list=[]}},mounted:function(){this.scroll=new f.a(this.$refs.search)}},B={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",[t("div",{staticClass:"search"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.keyword,expression:"keyword"}],staticClass:"search-input",attrs:{type:"text",placeholder:"搜索"},domProps:{value:e.keyword},on:{input:function(o){o.target.composing||(e.keyword=o.target.value)}}})]),e._v(" "),t("div",{directives:[{name:"show",rawName:"v-show",value:e.keyword,expression:"keyword"}],ref:"search",staticClass:"search-content"},[t("div",[e._l(e.list,function(o){return t("div",{key:o.id,staticClass:"item"},[t("img",{attrs:{src:e.getImageUrl(o.image)}}),e._v(" "),t("div",{staticClass:"content border-bottom"},[e._v(e._s(o.name))])])}),e._v(" "),t("div",{directives:[{name:"show",rawName:"v-show",value:!e.list.length,expression:"!list.length"}],staticClass:"item center"},[e._v("\n        没有找到匹配数据\n      ")])],2)])])},staticRenderFns:[]};var _=t("VU/8")(g,B,!1,function(e){t("Hsgg")},"data-v-409e5a5e",null).exports,w={name:"List",props:{phoneBooks:Object,letter:String},methods:{getImageUrl:function(e){return c("image/"+e)}},mounted:function(){this.scroll=new f.a(this.$refs.wrapper,{click:!0})},watch:{letter:function(){if(this.letter){var e=this.$refs[this.letter][0];this.scroll.scrollToElement(e)}}}},b={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{ref:"wrapper",staticClass:"list"},[t("div",e._l(e.phoneBooks,function(o,n){return t("div",{key:n,ref:n,refInFor:!0,staticClass:"phoneBook"},[t("div",{staticClass:"title"},[e._v(e._s(n))]),e._v(" "),e._l(o,function(o){return t("router-link",{key:o.id,staticClass:"item",attrs:{to:"/detail/"+o.id,tag:"div"}},[t("img",{attrs:{src:e.getImageUrl(o.image)}}),e._v(" "),t("div",{staticClass:"content border-bottom"},[e._v(e._s(o.name))])])})],2)}),0)])},staticRenderFns:[]};var C=t("VU/8")(w,b,!1,function(e){t("xz5j")},"data-v-69bfffb0",null).exports,y={name:"Alphabet",data:function(){return{touchStatus:!1,startY:0,timer:null}},props:{phoneBooks:Object},computed:{letters:function(){var e=[];for(var o in this.phoneBooks)console.log(o),e.push(o);return e}},methods:{handleLetterClick:function(e){console.log(e.target.innerText),this.$emit("change",e.target.innerText)},handleTouchStart:function(){this.touchStatus=!0,console.log("start")},handleTouchMove:function(e){var o=this;console.log("move"),this.timer&&clearTimeout(this.timer),this.timer=setTimeout(function(){if(o.touchStatus){var t=e.touches[0].clientY-79,n=Math.floor((t-o.startY)/20);n>=0&&n<o.letters.length&&o.$emit("change",o.letters[n])}},20)},handleTouchEnd:function(){this.touchStatus=!1,console.log("end")}},updated:function(){this.startY=this.$refs.A[0].offsetTop}},N={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("ul",{staticClass:"list"},e._l(e.letters,function(o,n){return t("li",{key:o,ref:o,refInFor:!0,staticClass:"item",on:{click:e.handleLetterClick,touchstart:e.handleTouchStart,touchmove:e.handleTouchMove,touchend:e.handleTouchEnd}},[e._v(e._s(o))])}),0)},staticRenderFns:[]};var x={name:"PhoneBook",data:function(){return{phoneBooks:{},letter:""}},components:{PhoneBookHeader:k,PhoneBookSearch:_,PhoneBookList:C,PhoneBookAlphabet:t("VU/8")(y,N,!1,function(e){t("UxhI")},"data-v-b72199c4",null).exports},methods:{refreshToken:function(){var e=window.localStorage.getItem("token");l.a.defaults.headers.common.token=e;var o=c("refreshToken");l.a.get(o).then(function(e){console.log("token刷新："+e.data.token),window.localStorage.setItem("token",e.data.token)}).catch(function(e){console.log(e)})},getPhoneBooks:function(){var e=this,o=window.localStorage.getItem("token");l.a.defaults.headers.common.token=o;var t=c("phoneBook/loadAll");l.a.get(t).then(function(o){console.log(o),e.phoneBooks=o.data.data}).catch(function(e){console.log(e)})},handleLetterChange:function(e){console.log("传来的字母:"+e),this.letter=e}},mounted:function(){var e=this;setInterval(this.refreshToken,6e5),this.getPhoneBooks(),p.a.subscribe("refreshPhoneBook",function(o,t){console.log("收到消息 refreshPhoneBook"),e.getPhoneBooks()})}},I={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",[t("phone-book-header"),e._v(" "),t("phone-book-search",{attrs:{phoneBooks:e.phoneBooks}}),e._v(" "),t("phone-book-list",{attrs:{letter:e.letter,phoneBooks:e.phoneBooks}}),e._v(" "),t("phone-book-alphabet",{attrs:{phoneBooks:e.phoneBooks},on:{change:e.handleLetterChange}})],1)},staticRenderFns:[]};var $=t("VU/8")(x,I,!1,function(e){t("/YRK")},"data-v-1777de55",null).exports,A=t("bOdI"),P=t.n(A),G={name:"Gallery",props:{galleryImage:String},methods:{hideClick:function(){this.$emit("hideGalleryClick")}}},T={render:function(){var e=this.$createElement,o=this._self._c||e;return o("div",{staticClass:"container",on:{click:this.hideClick}},[o("div",{staticClass:"wrapper"},[o("img",{attrs:{src:this.galleryImage,alt:""}})])])},staticRenderFns:[]};var S=t("VU/8")(G,T,!1,function(e){t("PWPL")},"data-v-d43d318a",null).exports,U={name:"Add",data:function(){return{phoneBook:{image:"default.jpg"},showGallery:!1,galleryImage:""}},components:{Gallery:S},methods:{getImageUrl:function(e){return c("image/"+e)},imageClick:function(){this.$refs.file.click()},showGalleryClick:function(){this.galleryImage=c("image/"+this.phoneBook.image),this.showGallery=!0},hideGalleryClick:function(){this.showGallery=!1},addInfo:function(){var e=this,o=c("phoneBook/save"),t=window.localStorage.getItem("token");if(l.a.defaults.headers.common.token=t,null!=this.phoneBook.name&&""!=this.phoneBook.name.trim())if(null!=this.phoneBook.phoneNumber&&""!=this.phoneBook.phoneNumber.trim()){if(/^1[3456789]\d{9}$/.test(this.phoneBook.phoneNumber))return null==this.phoneBook.teleNumber||""==this.phoneBook.teleNumber.trim()||/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(this.phoneBook.teleNumber)?void l.a.post(o,P()({name:this.phoneBook.name,phoneNumber:this.phoneBook.phoneNumber,teleNumber:this.phoneBook.teleNumber,workAddress:this.phoneBook.workAddress,homeAddress:this.phoneBook.homeAddress,image:this.phoneBook.image,remark:this.phoneBook.remark},"image",this.phoneBook.image)).then(function(o){0==o.data.code?(alert("添加成功"),p.a.publish("refreshPhoneBook",""),e.$router.replace("/phoneBook")):alert(o.data.msg)}).catch(function(e){alert(e)}):(alert("固定电话有误，请重填"),!1);alert("手机号码有误，请重填")}else alert("手机号码不为空！");else alert("姓名不为空！")},upload:function(e){var o=this,t=e.target.files[0],n=new FormData;n.append("file",t,t.name),console.log(n.get("file"));var a=window.localStorage.getItem("token"),r=c("uploadImage"),s={headers:{"Content-Type":"multipart/form-data",token:a}};l.a.post(r,n,s).then(function(e){0==e.data.code&&(o.phoneBook.image=e.data.data.title)}).catch(function(e){console.log(e)})}}},j={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{staticClass:"detail"},[t("div",{staticClass:"header"},[t("router-link",{staticClass:"iconfont",attrs:{tag:"div",to:"/phoneBook"}},[e._v("")])],1),e._v(" "),t("div",{staticClass:"image"},[t("div",{staticClass:"info"},[t("img",{attrs:{src:e.getImageUrl(e.phoneBook.image)},on:{click:e.showGalleryClick}})]),e._v(" "),t("div",{staticClass:"action"},[t("button",{on:{click:e.imageClick}},[e._v("修改头像")]),e._v(" "),t("input",{ref:"file",attrs:{type:"file",name:"file",accept:"image/png,image/gif,image/jpeg,image/jpg"},on:{change:e.upload}})])]),e._v(" "),t("div",{staticClass:"userInfo"},[t("div",{staticClass:"item border-bottom"},[t("span",[e._v("姓名")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.name,expression:"phoneBook.name"}],attrs:{type:"text"},domProps:{value:e.phoneBook.name},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"name",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("手机号码")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.phoneNumber,expression:"phoneBook.phoneNumber"}],attrs:{type:"text"},domProps:{value:e.phoneBook.phoneNumber},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"phoneNumber",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("座机电话号码")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.teleNumber,expression:"phoneBook.teleNumber"}],attrs:{type:"text"},domProps:{value:e.phoneBook.teleNumber},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"teleNumber",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("工作单位地址")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.workAddress,expression:"phoneBook.workAddress"}],domProps:{value:e.phoneBook.workAddress},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"workAddress",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("家庭地址")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.homeAddress,expression:"phoneBook.homeAddress"}],domProps:{value:e.phoneBook.homeAddress},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"homeAddress",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("备注")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.remark,expression:"phoneBook.remark"}],domProps:{value:e.phoneBook.remark},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"remark",o.target.value)}}})])]),e._v(" "),t("div",{staticClass:"action"},[t("div",{staticClass:"item border-bottom"},[t("a",{on:{click:e.addInfo}},[e._v("保存")])])]),e._v(" "),t("gallery",{directives:[{name:"show",rawName:"v-show",value:e.showGallery,expression:"showGallery"}],attrs:{galleryImage:e.galleryImage},on:{hideGalleryClick:e.hideGalleryClick}})],1)},staticRenderFns:[]};var E=t("VU/8")(U,j,!1,function(e){t("hBh4")},"data-v-6679a86a",null).exports,F={name:"Detail",data:function(){return{phoneBook:{image:"default.jpg"},showGallery:!1,galleryImage:""}},components:{Gallery:S},methods:{getImageUrl:function(e){return c("image/"+e)},imageClick:function(){this.$refs.file.click()},showGalleryClick:function(){this.galleryImage=c("image/"+this.phoneBook.image),this.showGallery=!0},hideGalleryClick:function(){this.showGallery=!1},deleteInfo:function(){var e=this;if(confirm("您确定要删除这条记录吗？")){var o=c("phoneBook/delete"),t=window.localStorage.getItem("token");l.a.defaults.headers.common.token=t,l.a.get(o,{params:{id:this.phoneBook.id}}).then(function(o){0==o.data.code?(alert("删除成功"),p.a.publish("refreshPhoneBook",""),e.$router.replace("/phoneBook")):alert(o.data.msg)}).catch(function(e){alert(e)})}},updateInfo:function(){var e=this,o=c("phoneBook/save"),t=window.localStorage.getItem("token");if(l.a.defaults.headers.common.token=t,null!=this.phoneBook.name&&""!=this.phoneBook.name.trim())if(null!=this.phoneBook.phoneNumber&&""!=this.phoneBook.phoneNumber.trim()){if(/^1[3456789]\d{9}$/.test(this.phoneBook.phoneNumber))return null==this.phoneBook.teleNumber||""==this.phoneBook.teleNumber.trim()||/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(this.phoneBook.teleNumber)?void l.a.post(o,P()({id:this.phoneBook.id,name:this.phoneBook.name,phoneNumber:this.phoneBook.phoneNumber,teleNumber:this.phoneBook.teleNumber,workAddress:this.phoneBook.workAddress,homeAddress:this.phoneBook.homeAddress,image:this.phoneBook.image,remark:this.phoneBook.remark},"image",this.phoneBook.image)).then(function(o){0==o.data.code?(alert("修改成功"),p.a.publish("refreshPhoneBook",""),e.$router.replace("/phoneBook")):alert(o.data.msg)}).catch(function(e){alert(e)}):(alert("固定电话有误，请重填"),!1);alert("手机号码有误，请重填")}else alert("手机号码不为空！");else alert("姓名不为空！")},upload:function(e){var o=this,t=e.target.files[0],n=new FormData;n.append("file",t,t.name),console.log(n.get("file"));var a=window.localStorage.getItem("token"),r=c("uploadImage"),s={headers:{"Content-Type":"multipart/form-data",token:a}};l.a.post(r,n,s).then(function(e){0==e.data.code&&(o.phoneBook.image=e.data.data.title)}).catch(function(e){console.log(e)})},getInfo:function(){var e=this,o=c("phoneBook/findById"),t=window.localStorage.getItem("token");l.a.defaults.headers.common.token=t,l.a.get(o,{params:{id:this.$route.params.id}}).then(function(o){e.phoneBook=o.data.phoneBook}).catch(function(e){alert(e)})}},mounted:function(){this.getInfo()}},R={render:function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{staticClass:"detail"},[t("div",{staticClass:"header"},[t("router-link",{staticClass:"iconfont",attrs:{tag:"div",to:"/phoneBook"}},[e._v("")])],1),e._v(" "),t("div",{staticClass:"image"},[t("div",{staticClass:"info"},[t("img",{attrs:{src:e.getImageUrl(e.phoneBook.image)},on:{click:e.showGalleryClick}})]),e._v(" "),t("div",{staticClass:"action"},[t("button",{on:{click:e.imageClick}},[e._v("修改头像")]),e._v(" "),t("input",{ref:"file",attrs:{type:"file",name:"file",accept:"image/png,image/gif,image/jpeg,image/jpg"},on:{change:e.upload}})])]),e._v(" "),t("div",{staticClass:"userInfo"},[t("div",{staticClass:"item border-bottom"},[t("span",[e._v("姓名")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.name,expression:"phoneBook.name"}],attrs:{type:"text"},domProps:{value:e.phoneBook.name},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"name",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("手机号码")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.phoneNumber,expression:"phoneBook.phoneNumber"}],attrs:{type:"text"},domProps:{value:e.phoneBook.phoneNumber},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"phoneNumber",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("座机电话号码")]),e._v(" "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.teleNumber,expression:"phoneBook.teleNumber"}],attrs:{type:"text"},domProps:{value:e.phoneBook.teleNumber},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"teleNumber",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("工作单位地址")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.workAddress,expression:"phoneBook.workAddress"}],domProps:{value:e.phoneBook.workAddress},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"workAddress",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("家庭地址")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.homeAddress,expression:"phoneBook.homeAddress"}],domProps:{value:e.phoneBook.homeAddress},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"homeAddress",o.target.value)}}})]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("span",[e._v("备注")]),e._v(" "),t("textarea",{directives:[{name:"model",rawName:"v-model",value:e.phoneBook.remark,expression:"phoneBook.remark"}],domProps:{value:e.phoneBook.remark},on:{input:function(o){o.target.composing||e.$set(e.phoneBook,"remark",o.target.value)}}})])]),e._v(" "),t("div",{staticClass:"action"},[t("div",{staticClass:"item border-bottom"},[t("a",{on:{click:e.updateInfo}},[e._v("保存")])]),e._v(" "),t("div",{staticClass:"item border-bottom"},[t("a",{on:{click:e.deleteInfo}},[e._v("删除")])])]),e._v(" "),t("gallery",{directives:[{name:"show",rawName:"v-show",value:e.showGallery,expression:"showGallery"}],attrs:{galleryImage:e.galleryImage},on:{hideGalleryClick:e.hideGalleryClick}})],1)},staticRenderFns:[]};var V=t("VU/8")(F,R,!1,function(e){t("72TY")},"data-v-96352a22",null).exports;n.a.use(s.a);var H=new s.a({routes:[{path:"/",name:"Login",component:m},{path:"/phoneBook",name:"PhoneBook",component:$},{path:"/add",name:"Add",component:E},{path:"/detail/:id",name:"Detail",component:V}]});t("9n10"),t("M6Sr"),t("TzC8");n.a.config.productionTip=!1,new n.a({el:"#app",router:H,components:{App:r},template:"<App/>"})},PWPL:function(e,o){},TVuH:function(e,o){},TzC8:function(e,o){},UxhI:function(e,o){},Yr2x:function(e,o){},hBh4:function(e,o){},xz5j:function(e,o){}},["NHnr"]);
//# sourceMappingURL=app.a5743a10d38ca0949e25.js.map