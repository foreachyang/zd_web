window.onload = function (){

		var speed=40; //speed

		var zhicheng_wai=document.getElementById("zhicheng_wai");

		var zhicheng_nei=document.getElementById("zhicheng_nei");

		var zhicheng_con=document.getElementById("zhicheng_con");

		zhicheng_con.innerHTML=zhicheng_nei.innerHTML;

		function Marquee(){

			if(zhicheng_con.offsetWidth-zhicheng_wai.scrollLeft<=0) {

				zhicheng_wai.scrollLeft-=zhicheng_nei.offsetWidth

			}else{

				zhicheng_wai.scrollLeft++;

			}

		}

		var MyMar=setInterval(Marquee,speed);

		zhicheng_wai.onmouseover=function() {clearInterval(MyMar)};

		zhicheng_wai.onmouseout=function() {MyMar=setInterval(Marquee,speed)};

	}