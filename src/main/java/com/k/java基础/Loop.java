package com.k.java基础;

/**
 * 循环里continue,break和retry的关系
 * @author k
 * @date 2019/10/8 15:46
 **/
public class Loop {

	public static void main(String[] args) {
		loop2();
	}

	static void loop1(){
		int i=0;
		for(;;){
			if(i==100){
				break;
			}
			i++;
		}
    	System.out.println(i);
		for(;;){
			for(;;){
				i++;
				if(i==500){
					//直接中断方法
					return;
				}
			}
		}
	}

	static void loop2(){
		int i=0;
		retry:
		for(;;){
			i++;
			if(i%100 == 0){
				//使用continue会回到retry重新循环
				//使用break会直接中断这次循环
//				continue retry;
				break retry;
			}
		}

		retry2:
		for(i=0;i<99999;i++){
			retry3:
			for(;;){
				i++;
				if(i==11199999){
          			System.out.println(11199999);
          			//无限从retry3开始
					continue retry3;
				}
			}
//			if(i==99998){
//				System.out.println(99998);
//				continue retry2;
//			}
		}
	}
}
