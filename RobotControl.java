import javax.swing.JOptionPane;

class RobotControl {
	private Robot r;
	public static StringBuilder sb;

	//declare constants 
	private final int SOURCE_LOCATION = 10; 
	private final int TARGET_1 = 1;
	private final int TARGET_2 = 2;
	private final int FIRST_BAR_POSITION = 3;

	public RobotControl(Robot r) {
		this.r = r;
	}

	public void control(int barHeights[], int blockHeights[]) {
		
		run(barHeights, blockHeights);

	}

	/*BEGIN 
	DECLARE variables 
	INITIALIZE a constant SOURCE LOCATION as 10
	INITIALIZE a constant TARGET_1 as 1
	INITIALIZE a constant TARGET_2 as 2 
	INITIALIZE a constant FIRST_BAR_POSITION as 3
	INITIALIZE height h of robot arm as 2
	INITIALIZE width w of the robot arm as 1
	INITIALIZE depth d of the robot arm d as 0 
	INITIALIZE the height of the blocks at the source location sourceHt as 0
	COMPUTE the height of the blocks at the source location  
		FOR initial value of s as 0 
		compare the value of s with the length of the array blockHeights whilst incrementing it by 1 
		value of sourceHt = the value of the block height at s + previous height of the source 
	COMPUTE clearance the maximum height the robot arm can move without any obstacles  
	INITIALIZE clearance  as equal to the height of the blocks at the source location 
	INITIALIZE the index value of the current block which is equal to the length of the array blockHeights - 1
	INITIALIZE the bar at use currentBar as 0
	INITIALIZE the column containing size 1 blocks targetColHt1 as 0
	INITIALIZE the column containing size 2 blocks targetColHt2 as 0
	COMPUTE maximum clearance 
	INITIALIZE the array to compute the maximum clearance 
	The array to compute the maximum clearance when blocks are on top of bars  is equal to the array containing the bar heights 
	COMPUTE the amount the height of the robot arm increases 
	WHILE the clearance + 1 is greater than the height of the robot arm 
		Height of the robot arm increases 
	COMPUTE the amount the robot arm extends to pick up the blocks from the source location 
	INITIALIZE the amount to increase the width of the robot arm as 10
	WHILE the amount of the current block is less than or equal to 0
		INITIALIZE the amount robot arm should extend  according to the block size as 0
		IF the size of the current block is 1 
			amount robot arm should extend  according to the block size is the value of the location of the blocks - the value of the column containing size 1 blocks 
		END IF
		IF the size of the current block is 2 
			amount robot arm should extend  according to the block size is the value of the location of the blocks - the value of the column containing size 2 blocks 
		END IF 
		IF the size of the current block is 3 
			amount robot arm should extend  according to the block size is the value of the location of the blocks - the value of the column containing size 3 blocks 
	 	END IF 
			IF the amount to increase the width of the robot arm is greater than the amount robot arm should extend  according to the block size 
		END IF 
				WHILE width of the arm is less than amount robot arm should extend according to the block size
					Extend the value of the robot arm by increasing width 
	COMPUTE the amount the robot arm lowers to get the block 
	WHILE h - d is greater than the height of the blocks at the source location + 1
		Lower the robot arm by decreasing d
	Pick the block 
	Value of the blocks at the source location is equal to the Previous value of the blocks at the source location - the value of the current block 
	COMPUTE the maximum bar height
	INITIALIZE the maximum bar height as 0 
	INITIALIZE the index value of the bar indexBar as 0 
	As long as indexBar is less than the length of the array barHeights increase indexBar
		IF the size of the bar at the indexBar value is greater than the value of maximum bar height 
		maximum bar height =  size of the bar at the indexBar value 
		END IF 
	Clearance is equal to the maximum bar height
	COMPUTE maximum block height 
	INITIALIZE the maximum block height as 0 
	INITIALIZE the index value of the block indexBar as 0 
	As long as indexBlock is less than the length of the array blockHeights increase indexBlock
		IF the size of the block at the indexBlock value is greater than the value of maximum block height 
		maximum block height =  size of the block at the indexBlock value 
		END IF 
	COMPUTE new clearance 
	INITIALIZE the amount of depth decreased as rising Amount = 0
	INITIALIZE the new clearance amount as 0
	IF the current block is equal to 3 
		INITIALIZE the i as the size of the current bar 
	 		IF  i is less than the value of the length of the bar heights
				Increase the value of i by 1  
			END IF 
		INITIALIZE a variable clearBar as the value of the array of the maximum clearance 	when blocks are on top of bars  is equal to the array containing the bar heights  + 	the value of the current block 
				IF clearBar is greater than the value of the new clearance 
					new clearance = clearBar 
				END IF 
			ELSE  
				INITIALIZE a variable i as 0
		INITIALIZE a variable clearBar as the value of the array of the maximum clearance 	when blocks are on top of bars  is equal to the array containing the bar heights  + 	the value of the current block 
				IF clearBar is greater than the value of the new clearance 
					new clearance = clearBar 
				END IF 
	END IF 
	COMPUTE the amount the robot arm rises from the source height 
	IF the current block size is equal to 1 or 2 
		the rising amount is equal to h -1 - new clearance 
	END IF 
	IF the current block height is equal to 3 
		IF sourceHt is greater than the clearance) 
	rising Amount  is equal to h - clearance)- value of the current Block - 1
			IF sourceHt is greater than the  clearance + maxBlockHeight
			rising Amount is equal to h - clearance + max Block Height - current Block - 1
			END IF  
		END IF 
		IF sourceHt is greater than clearance
			INITIALIZE  new variable maxBarHeight2  as 0
			INITIALIZE new variable  indexBar2 as the value of the current Bar index
				IF indexBar2 is greater than the value at the  barHeights.length array increase value of indexBar2 by 1 
	         			IF  the value of the barHeights at the indexBar2is greater than maxBarHeight2
					maxBarHeight2 = barHeights[indexBar2];
					END IF 
				END IF 
			Value of clearance = maxBarHeight2
		rising Amount is equal to the h - maxBarHeight2 - value of the current block height - 1
		END IF 
	END IF 
	WHILE value of the robot arm d is greater than the rising amount 
		Decrease the value of d
	COMPUTE the value to contract the robot arm for different block heights  
	WHILE the amount of the current block is less than or equal to 0
		INITIALIZE the amount robot arm should contract according to the block size as 0
		IF the size of the current block is 1 
			amount robot arm should contract according to the block size is the value of the location of the blocks - the value of the column containing size 1 blocks 
		END IF
		IF the size of the current block is 2 
			amount robot arm should contract according to the block size is the value of the location of the blocks - the value of the column containing size 2 blocks 
		END IF 
		IF the size of the current block is 3 
			amount robot arm should contract according to the block size is the value of the location of the blocks - the value of the column containing size 3 blocks 
	 	END IF 
		INITIALIZING the amount to contract the arm as the value to contract the robot 	arm for different block heights		
		WHILE amount to contract the arm is greater than  0
		Contract the robot arm by decreasing width 
	COMPUTE the value to lower the robot arm by increasing d 
	INITIALIZING lowering amount as 0
	IF  the the value of the current Block = 1
		The lowering Amount is equal to the lowing amount  + height of the column containing size 1 blocks 
		column containing size 1 blocks  = column containing size 1 blocks + value of the current Block
	END IF 
	IF the value of the current Block = 2)
		The lowering Amount is equal to the lowing amount  + height of the column containing size 2 blocks 
		column containing size 2 blocks  = column containing size 2 blocks + value of the current Block
	END IF 
	IF the value of the current Block = 3 
		The lowering Amount is equal to the value of the current Bar
	END IF 
	WHILE h - 1 - d - the value of the current block is greater 
	Lower the robot arm by increasing the value of d 
	Drop the block 
	INITIALIZE new variable to find the new clearance newClearance2 as 0 
	INITIALIZE the i as the size of the current bar 
		IF  i is less than the value of the length of the bar heights	
			Increase the value of i by 1  
		END IF 
		IF clearBar is greater than the value of the new clearance 
			new clearance2 = clearBar 
		END IF 
	END IF 
	COMPUTE the amount to raise the robot arm after dropping in order to get the next block 
	INITIALIZE new variable to find the maximum amount the robot arm can be risen  safeDepth as 0
	IF the value of the current Block is equal 1 
		IF the sourceHt is greater than or equal to newClearance2
		safeDepth is equal to  h - 1 - sourceHt
			ELSE 
				IF newClearance2  is greater than  sourceHt
		       		 safeDepth is equal to  h - 1 - newClearance2
	         		END IF 
		IF the value of the newClearance2 equal to sourceHt
		safeDepth equal to (h - 1) - newClearance2
		END IF 	
	END IF 
	IF the value of the current Block is equal  2
		IF the value of the sourceHt is greater than or equal to the value of  newClearance2
		safeDepth is equal to  h - 1- sourceHt
	          ELSE 
			IF the value of the newClearance2 is greater than the sourceHt 
			safeDepth is equal to h - 1 - newClearance2
			END IF 
		END IF 
	END IF 
	IF the value of the current Block is equal to 3
	INITIALIZING new variable the maximum bar height maxBarHeight3 as 0 
	INITIALIZING new variable for the index of the array as indexBar3 which is equal to the value of the current bar 
		FOR  the value of indexBar3 is less than that of the length of the array barHeights.length 
	 	Increase the value of indexBar3+ by 1 
		IF the value of the barHeights[indexBar3] is less than the value of the maximum bar height 
		maxBarHeight3 = barHeights[indexBar3];
	clearance = maxBarHeight3;
			IF h - 1 - d is less than the clearance
			the value of safeDepth is equal to the clearance - h - 1 - d
			END IF 
		END IF 
	IF the value of the clearance is less than or equal to the value of the sourceHt
		The value of safeDepth is equal to  h - 1 - sourceHt
	ELSE 
		The value of safeDepth is equal to h - 1 - clearance
	END IF 
	END IF 
	COMPUTE the value to end the program 
	IF the value at the source location is equal to 0 
	safeDepth is equal to the value of the lowering amount 	
	END IF 
	WHILE d is greater than the safeDepth 
	Decrease the value of d to raise the arm of the robot 
	IF the current block size is equal to 3 
	The value of the current bar is increase by one 
	END IF 
	The value of the current block is decreased by one in order to end the loop after a specific number of loops 
	*/		

	public void run(int barHeights[], int blockHeights[]) {
		// declare initial variables
		int h = 2;
		int w = 1;
		int d = 0;
		int sourceHt = 0;
		for (int s = 0; s < blockHeights.length; s++) { // COMPUTE the height of the blocks at the source location
														// iteratively

			sourceHt += blockHeights[s];// sourceHt = the value of the block height at s + previous height of the source
		}
		int clearance = sourceHt;// the maximum height the robot arm can move without obstacles is clearance
									// which is equal to height of blocks at source location

		int currentBlock = blockHeights.length - 1; // index value of the block in use is equal to the length of the
													// array blockHeights - 1
		int currentBar = 0;
		int targetCol1Ht = 0;
		int targetCol2Ht = 0;
		int barAndBlockHeights[]; // Array to compute the maximum clearance
		barAndBlockHeights = barHeights; // when blocks are on top of bars
		while (h < clearance + 1) // Increase the height of robot arm h
		{
			r.up();

			h++;
		}
		int extendAmt1 = 10;

		while (currentBlock >= 0) {

			int actualExtendAmt = 0; // Find the amount by which arm w is extended for different block heights
			if (blockHeights[currentBlock] == 1) {
				actualExtendAmt = SOURCE_LOCATION - TARGET_1;
			}
			if (blockHeights[currentBlock] == 2) {
				actualExtendAmt = SOURCE_LOCATION - TARGET_2;
			}
			if (blockHeights[currentBlock] == 3) {
				actualExtendAmt = SOURCE_LOCATION - FIRST_BAR_POSITION;
			}

			{
				if (extendAmt1 > actualExtendAmt) // Extend robot arm w
				{
					while (w < extendAmt1) {
						r.extend();
						w++;
					}
				}
			}

			while ((h - d) > sourceHt + 1)// Find the amount by which arm d is lowered
			{
				r.lower();
				d++;
			}

			r.pick();

			sourceHt -= blockHeights[currentBlock];// Value of the blocks at the source location is equal to the
													// Previous value of the blocks at the source location - the value
													// of the current block

			int maxBarHeight = 0; // Find the maximum bar height by comparing with all the bar heights 
			for (int indexBar = 0; indexBar < barHeights.length; indexBar++) { 
				if (barHeights[indexBar] > maxBarHeight) 
				{
					maxBarHeight = barHeights[indexBar]; // maximum bar height is the value of the bar at the indexBar value

				}
			}

			clearance = maxBarHeight; 

			int maxBlockHeight = 0; // Find the maximum block height by comparing block heights with each and every block height 
			for (int indexBlock = 0; indexBlock < blockHeights.length; indexBlock++) { // If the indexBlock is less than the length of the array 
				if (blockHeights[indexBlock] > maxBlockHeight) {                           //Increase the value of the indexBlock by one 
					maxBlockHeight = blockHeights[indexBlock]; //Maximum block height is equal to the value of the block heights array when the index is indexBlock
				}
			}

			// Find the amount to raise the arm d

			int risingAmt = 0;
			int newClearance = 0;

			if (blockHeights[currentBlock] == 3) {
				for (int i = currentBar; i < barHeights.length; i++)
				
				{
					int clearBar = barAndBlockHeights[i] + blockHeights[currentBlock]; // clearBar is the value of the maximum
																						// clearance when blocks are on
																						// top of bars which is equal to the value of the 
																						// array containing the bar and block
																						// heights + the value of the
																						// current block
					if (clearBar > newClearance) {
						newClearance = clearBar;

					}
				}
			} else {
				for (int i = 0; i < barHeights.length; i++) { // Compute the new clearance to which the arm can rise without any obstacles 
					int clearBar = barAndBlockHeights[i] + blockHeights[currentBlock]; 
					if (clearBar > newClearance) {
						newClearance = clearBar;

					}
				}
			}

			if (blockHeights[currentBlock] == 1 || blockHeights[currentBlock] == 2) {
				// The amount that the robot arm raises from the source height without colliding in to obstacles 
			
				risingAmt = h - 1 - newClearance;

			}
			if (blockHeights[currentBlock] == 3) {
				if (sourceHt > clearance) {
					risingAmt = ((((h - clearance) - blockHeights[currentBlock])) - 1);

					if (sourceHt > clearance + maxBlockHeight) {
						risingAmt = ((((h - (clearance + maxBlockHeight)) - blockHeights[currentBlock])) - 1);

					}
				}

				if (sourceHt < clearance) {

					int maxBarHeight2 = 0; 
					                         
					for (int indexBar2 = currentBar; indexBar2 < barHeights.length; indexBar2++) {// indexBar2 is incremented as long as the condition of indexBar2 < barHeights.lenght is true
						if (barHeights[indexBar2] > maxBarHeight2) {
							maxBarHeight2 = barHeights[indexBar2];
						}
					}
					clearance = maxBarHeight2;
					risingAmt = ((((h - maxBarHeight2) - blockHeights[currentBlock])) - 1);

				}
			}
			while (d > risingAmt) {
				r.raise();
				d--;
			}

			int actualContractAmt = 0; // Find the amount to contract arm w for different block heights
			if (blockHeights[currentBlock] == 1) {
				actualContractAmt = SOURCE_LOCATION - TARGET_1;
			}
			if (blockHeights[currentBlock] == 2) {
				actualContractAmt = SOURCE_LOCATION - TARGET_2;
			}
			if (blockHeights[currentBlock] == 3) {
				actualContractAmt = SOURCE_LOCATION - FIRST_BAR_POSITION - currentBar;

			}
			int contractAmt = actualContractAmt;

			while (contractAmt > 0) {
				r.contract();
				contractAmt--;
				w--;
			}
			// Find the amount by which arm d is lowered
			int loweringAmt = 0;
			if (blockHeights[currentBlock] == 1) {
				loweringAmt = loweringAmt + targetCol1Ht;
				targetCol1Ht = targetCol1Ht + blockHeights[currentBlock];

			}
			if (blockHeights[currentBlock] == 2) {
				loweringAmt = loweringAmt + targetCol2Ht;
				targetCol2Ht = targetCol2Ht + blockHeights[currentBlock];

			}
			if (blockHeights[currentBlock] == 3) {
				loweringAmt = barHeights[currentBar];
			}

			while ((h - 1) - d - blockHeights[currentBlock] > loweringAmt)
			{
				r.lower();
				d++;
			}

			r.drop();
			int newClearance2 = 0;
			for (int i = 0; i < barHeights.length; i++) { // Find the new clearance value 
															
				int clearBar = barAndBlockHeights[i];
				if (clearBar > newClearance2) {
					newClearance2 = clearBar;

				}
			}

			if (blockHeights[currentBlock] == 3) {
				barAndBlockHeights[currentBar] += blockHeights[currentBlock]; // The value corresponding to the index of the
																				// current bar in the barAndBlockHeights array + the
																				// current block value is the new index
																				// value of the array barAndBlockHeights
			}
			// Find the amount by which arm d is risen for different block heights 
			int safeDepth = 0;

			if (blockHeights[currentBlock] == 1) {
				if (sourceHt >= newClearance2) {
					safeDepth = (h - 1) - sourceHt;
				} else if (newClearance2 > sourceHt) {
					safeDepth = (h - 1) - newClearance2;
				}
				if (newClearance2 == sourceHt) {
					safeDepth = (h - 1) - newClearance2;
				}
			}

			if (blockHeights[currentBlock] == 2) {

				if (sourceHt >= newClearance2) {

					safeDepth = (h - 1) - sourceHt;
				} else if (newClearance2 > sourceHt) {
					safeDepth = (h - 1) - newClearance2;

				}
			}

			if (blockHeights[currentBlock] == 3)

			{
				int maxBarHeight3 = 0;
				for (int indexBar3 = currentBar; indexBar3 < barHeights.length; indexBar3++) { //Compute the maximum  bar by comparing with the other bars 
					if (barHeights[indexBar3] > maxBarHeight3) {
						maxBarHeight3 = barHeights[indexBar3];
					}

					clearance = maxBarHeight3;

					if (((h - 1) - d) < clearance) {
						safeDepth = clearance - ((h - 1) - d);
					}
				}
				if (clearance <= sourceHt) {
					safeDepth = h - 1 - sourceHt;

				}

				else {
					safeDepth = h - 1 - clearance;
				}
			}

			if (sourceHt == 0) // Find the value to end the program 
			{
				safeDepth = d;
			}

			while (d > safeDepth) 
			{
				r.raise();
				d--;
			}

			if (blockHeights[currentBlock] == 3) {
				currentBar = currentBar + 1;
			}
			currentBlock = currentBlock - 1;

		}
	}
}
