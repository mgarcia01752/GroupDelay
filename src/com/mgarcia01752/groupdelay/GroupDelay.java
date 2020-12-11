package com.mgarcia01752.groupdelay;
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

public class GroupDelay {
	
	private List<IQComplexSample> lcs = new ArrayList<>();
	
	/**
	 * 
	 * @param lcs IQComplexSample
	 */
	public GroupDelay(List<IQComplexSample> lcs) {
		this.lcs = lcs;
	}
			
	/**
	 * @return Return of UnWrapped radians from the IQComplexSample List
	 */
	public List<Double> getPhaseUnWrappingList() {
		
		List<Double> ldUnWrapped = new ArrayList<>();
	
		/* Step 1 - Get Initial UnWrapped phase Value */
		ldUnWrapped.add(phaseUnwrapping(lcs.get(1).phase(),   //n
										lcs.get(0).phase())); //n-1
		
		/* Start Index -> n + 1*/
		for (int iN = 1; iN < lcs.size(); iN++) {
			
			/* Initial Settings */
			double dUnWrapPhase = lcs.get(iN).phase();
			double dWrapPhase = dUnWrapPhase;
			
							/* n - (n-1) */
			double dN = dWrapPhase; 				// n
			double dN_1 = ldUnWrapped.get(iN -1);	// n-1
							/* n - (n-1) */
			
			dUnWrapPhase = phaseUnwrapping(dN_1,dN);

			ldUnWrapped.add(dUnWrapPhase);

		}
	
		return ldUnWrapped;
		
	}
	
	/**
	 * 
	 * @param ldPhaseUnWrapping List of Unwrapped Radians
	 * @return List of each GroupDelayEntry by Frequency
	 */
	public List<GroupDelayEntry> getGroupDelayList(List<Double> ldPhaseUnWrapping) {
		
		List<GroupDelayEntry> lgde = new ArrayList<>();
		
		for (int idx = 0; idx < ldPhaseUnWrapping.size()-1; idx++) {
			lgde.add(new GroupDelayEntry(	this.lcs.get(idx+1).getSampleFrequency(), 
											getGroupDelay(	ldPhaseUnWrapping.get(idx+1),
															ldPhaseUnWrapping.get(idx),
															this.lcs.get(idx+1).getSampleFrequency(),
															this.lcs.get(idx).getSampleFrequency())));
		}
		
		return lgde;
		
	}
	
	/**
	 * 
	 * @param dPhase_N1 double n+1 radian data point
	 * @param dPhase_N	double n radian data point
	 * @return double unwrapped phase/radian sample
	 * 
	 * @apiNote 
	 * 
	 * Unlike some places I have worked, I do my best to pass the credit along
	 * 
	 * Source: http://www.cjs-labs.com/sitebuildercontent/sitebuilderfiles/GroupDelay.pdf
	 * 
	 * Phase unwrapping can be done as follows:
			While
			 (Phase(n) - Phase(n-1))< -180)
			Do
			 Phase(n) = Phase(n) + 360;
			While
			 (Phase(n) - Phase(n-1)) > 180)
			 Do
			 Phase(n)= Phase(n) - 360; 
	 * 
	 */
	private double phaseUnwrapping(double dPhase_N1, double dPhase_N) {

		while ((dPhase_N - dPhase_N1) <= -(Math.PI)) {
			dPhase_N = dPhase_N + 2*Math.PI;			
		}

		while ((dPhase_N - dPhase_N1) >= (Math.PI)) {
			dPhase_N = dPhase_N - 2*Math.PI;
		}
		
		return dPhase_N;
	}
	
	/**
	 * 
	 * @param dPhase_N1 Omega n-1 phase in radians
	 * @param dPhase_N Omega n-1 Radians
	 * @param iFreq_N1 Frequency n-1 
	 * @param iFreq_N Frequency n
	 * @return double Group Delay
	 * 
	 * @apiNote 
	 * 
	 * 	Unlike some places I have worked, I do my best to pass the credit along
	 * 	
	 * 	Source: http://www.cjs-labs.com/sitebuildercontent/sitebuilderfiles/GroupDelay.pdf
	 * 
	 * 		GroupDelay(n)=-1*[((ph(n+1)-ph(n-1))/(f(n+1)-f(n-1))]/(360)
	 *  
	 */
	private double getGroupDelay(double dPhase_N1 , double dPhase_N, int iFreq_N1, int iFreq_N ) {
		double dFreqDelta = ((double) iFreq_N - (double) iFreq_N1);
		double dOmega = dPhase_N1 - dPhase_N;
		double dGroupDelay = -(dOmega / (dFreqDelta * 2 * Math.PI));
		return dGroupDelay;		
	}
	

		
}
