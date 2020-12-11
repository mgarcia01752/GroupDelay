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

public class GroupDelayEntry {
	
	private int iCenterfrequency;
	private double dGroupDelay;
	
	/**
	 * 
	 * @param iCenterfrequency Center frequency of Group Delay sample
	 * @param dGroupDelay Group Delay in seconds
	 */
	public GroupDelayEntry (int iCenterfrequency, double dGroupDelay) {
		this.iCenterfrequency = iCenterfrequency;
		this.dGroupDelay = dGroupDelay;
	}
	
	public int getCenterFrequency() {
		return this.iCenterfrequency;
	}
	
	public double getGroupDelay() {
		return this.dGroupDelay;
	}
	
	public String toString() {	
		return "Frequency(hertz): " + getCenterFrequency() + " - " + "GroupDelay(seconds): " + String.format("%.12f", getGroupDelay());
	}
	
}
