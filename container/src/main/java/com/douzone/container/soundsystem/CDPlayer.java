package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	@Autowired
	private CompactDisc cd;
	
// 	@Autowired 말고 이렇게 사용하기를 권고
//	CDPlayer(CompactDisc cd){
//		this.cd = cd;
//	}
	public String play() {
		return cd.play();
	}
}
