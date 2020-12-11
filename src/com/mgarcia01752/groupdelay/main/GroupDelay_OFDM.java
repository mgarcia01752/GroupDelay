package com.mgarcia01752.groupdelay.main;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mgarcia01752.groupdelay.IQComplexSample;
import com.mgarcia01752.groupdelay.GroupDelay;
import com.mgarcia01752.groupdelay.GroupDelayEntry;

public class GroupDelay_OFDM {

	public static final String delimiter = ",";
	public static final boolean debug = false;

	public static List<IQComplexSample> read(String csvFile) {

		List<IQComplexSample> lcs = new ArrayList<>();

		try {

			File file = new File(sBasePath() + File.separator + "testfiles" + File.separator + csvFile);

			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);

			String line = "";

			String[] tempArr;

			while((line = br.readLine()) != null) {

				tempArr = line.split(delimiter);

				//Skip to check the first line contain any non-digit character
				if (!tempArr[0].matches("\\d+")) continue;

				lcs.add(new IQComplexSample(	Integer.parseInt(tempArr[0]),
								Double.parseDouble(tempArr[1]),
								Double.parseDouble(tempArr[2])));

				if (debug) {
					
					for(String tempStr : tempArr) {
						System.out.print(tempStr + "|");
					}

					System.out.println();
				}
			}

			br.close();

		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

		return lcs;

	}

	public static String sBasePath() {

		File file = new File(System.getProperty("java.class.path"));
		if (file.getParent() != null){
			return file.getParent().toString();
		}

		try {
			return new java.io.File("").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		//Open Test File Example
		GroupDelay gd = new GroupDelay(read("OFDM_CHAN_ESTIMATION.csv"));
		
		List<Double> ld = gd.getPhaseUnWrappingList();
				
		for (GroupDelayEntry gde :gd.getGroupDelayList(ld)) {
			System.out.println(gde.toString());
		}
		
		
	}

}
