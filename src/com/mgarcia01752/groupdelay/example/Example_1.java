package com.mgarcia01752.groupdelay.example;

/*
 * 	Licensed to the Apache Software Foundation (ASF) under one
	or more contributor license agreements.  See the NOTICE file
	distributed with this work for additional information
	regarding copyright ownership.  The ASF licenses this file
	to you under the Apache License, Version 2.0 (the
	"License"); you may not use this file except in compliance
	with the License.  You may obtain a copy of the License at
	
	  http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing,
	software distributed under the License is distributed on an
	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
	KIND, either express or implied.  See the License for the
	specific language governing permissions and limitations
	under the License.
	
	Author: Maurice Garcia
	email:	mgarcia01752@outlook.com
 */

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
		 	Group Delay Calculation for 200KHz of Bandwidth
		  
			FREQ		REAL(I)			Imaginary(Q)
			729700000	-1.050292969	0.223144531
			729750000	-0.984375	0.439697266
			729800000	-0.874755859	0.635986328
			729850000	-0.726806641	0.806274414
		*/
			
		liqcs.add(new IQComplexSample(729700000,-1.050292969,0.223144531));
		liqcs.add(new IQComplexSample(729750000,-0.984375,0.439697266));
		liqcs.add(new IQComplexSample(729800000,-0.874755859,0.635986328));
		liqcs.add(new IQComplexSample(729850000,-0.726806641,0.806274414));
		
		//Create GroupDelay Object using IQComplexSample List
		GroupDelay gd = new GroupDelay(liqcs);
		
		//Unwrap the phase data
		List<Double> ld = gd.getPhaseUnWrappingList();
		
		//Calculate Group Delay with unwrapped phase data
		//Data return will always be n-1 entries in seconds
		for (GroupDelayEntry gde :gd.getGroupDelayList(ld)) {
			System.out.println(gde.toString());
		}
		
		/*
		 	Frequency(hertz): 729750000 - GroupDelay(seconds): 0.000000670807
			Frequency(hertz): 729800000 - GroupDelay(seconds): 0.000000663868
			Frequency(hertz): 729850000 - GroupDelay(seconds): 0.000000663804
		 */
		
	}
	
	
}
