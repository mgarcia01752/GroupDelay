# API for wired transmission of OFDM/OFDMA GroupDelay Analysis in Java

**Purpose**

As coax systems are aging and have not been updated, cable operators are continuously increasing their data rates by both increasing QAM order and widening channel bandwidth using OFDM. One of the considerations is placing an OFDM near a cable roll-off. the immediate effect is a lowering of attenuation, which can result in a lower signal-to-noise (SNR) or MER. There is also a secondary effect is the Group Delay of the signal.  

This API is based on a paper written by CHRISTOPHER J. STRUCK titled [Group Delay](http://www.cjs-labs.com/sitebuildercontent/sitebuilderfiles/GroupDelay.pdf)

**API Usage**

Create a list of IQ or Complex samples that MUST include the Center Frequency to properly calcualte the group delay.


[Code Example 1](https://github.com/mgarcia01752/GroupDelay/blob/main/src/com/mgarcia01752/groupdelay/example/Example_1.java)

**Input Values**


	FREQ			REAL(Q)			Imaginary(I)
	729700000		-1.050292969		0.223144531
	729750000		-0.984375		0.439697266
	729800000		-0.874755859		0.635986328
	729850000		-0.726806641		0.806274414
	

**Group Delay Output**

	Frequency(hertz): 729750000 - GroupDelay(seconds): 0.000000670807
	Frequency(hertz): 729800000 - GroupDelay(seconds): 0.000000663868
	Frequency(hertz): 729850000 - GroupDelay(seconds): 0.000000663804

