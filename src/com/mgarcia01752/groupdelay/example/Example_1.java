package com.mgarcia01752.groupdelay.example;

import java.util.ArrayList;
import java.util.List;

import com.mgarcia01752.groupdelay.GroupDelay;
import com.mgarcia01752.groupdelay.GroupDelayEntry;
import com.mgarcia01752.groupdelay.IQComplexSample;

public class Example_1 {
	
	public static void main(String[] args) {
		
		/* Create a List Object that contains IQ or Complex data */
		List<IQComplexSample> liqcs = new ArrayList<>();
		
		/*
		 * Group Delay Calculation for 200KHz of Bandwidth
		 * 
			FREQ		REAL(Q)			Imaginary(I)
			729700000	-1.050292969	0.223144531
			729750000	-0.984375		0.439697266
			729800000	-0.874755859	0.635986328
			729850000	-0.726806641	0.806274414
		*/
			
		liqcs.add(new IQComplexSample(729700000,-1.050292969,0.223144531));
		liqcs.add(new IQComplexSample(729750000,-0.984375,0.439697266));
		liqcs.add(new IQComplexSample(729800000,-0.874755859,0.635986328));
		liqcs.add(new IQComplexSample(729850000,-0.726806641,0.806274414));
		
		//Create GroupDelay Object using IQComplexSample List
		GroupDelay gd = new GroupDelay(liqcs);
		
		//Unwrap the phase
		List<Double> ld = gd.getPhaseUnWrappingList();
		
		//Calculate Group Delay - Data return will always be n-1 entries in seconds
		for (GroupDelayEntry gde :gd.getGroupDelayList(ld)) {
			System.out.println(gde.toString());
		}
		
		
	}
	
	
}
