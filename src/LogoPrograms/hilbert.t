	PROC LHILBERT( LEVEL )
	    IF LEVEL != 0 THEN
		LEFT 90
		RHILBERT ( LEVEL - 1 )
		FORWARD 4
		RIGHT 90
		LHILBERT ( LEVEL - 1 )
		FORWARD 4
		LHILBERT ( LEVEL - 1 )
		RIGHT 90
	 	FORWARD 4
		RHILBERT ( LEVEL - 1 )
		LEFT 90
	    ELSE
		FORWARD 0
	    ENDIF		

	PROC RHILBERT( LEVEL )
            IF LEVEL != 0 THEN
                RIGHT 90
                LHILBERT ( LEVEL - 1 )
                FORWARD 4
                LEFT 90
                RHILBERT ( LEVEL - 1 )
                FORWARD 4
                RHILBERT ( LEVEL - 1 )
                LEFT 90
                FORWARD 4            
                LHILBERT ( LEVEL - 1 ) 
                RIGHT 90       
            ELSE       
                FORWARD 0      
            ENDIF 

	 PROC MAIN (VOID)
	    LHILBERT(6)
