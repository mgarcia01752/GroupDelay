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

public class IQComplexSample extends Complex {

	private int iSamplefreqHertz = 0;
	
	/**
	 * 
	 * @param iSamplefreqHertz Center Frequency of Sample
	 * @param real Real or Q (quadrature) component of Complex
	 * @param imag Imaginary or I (in-phase) component of Complex
	 */
	public IQComplexSample(int iSamplefreqHertz, double dReal, double dImag) {
		super(dReal, dImag);
		this.iSamplefreqHertz = iSamplefreqHertz;
	}
	
	/**
	 * 
	 * @param iSamplefreqHertz Center Frequency of Sample
	 * @param Complex containing both real Real or Q (quadrature) components
	 */
	public IQComplexSample(int iSamplefreqHertz, Complex c) {
		super(c.re(),c.im());
		this.iSamplefreqHertz = iSamplefreqHertz;
	}
	
	/**
	 * 
	 * @return Center Frequency of sample
	 */
	public int getSampleFrequency() {
		return iSamplefreqHertz;
	}
}
