%!PS-Adobe-3.0
/Xpos    { 300 } def
/Ypos    { 500 } def
/Heading { 0   } def
/Arg     { 0   } def
/Right   {
Heading exch add Trueheading
/Heading exch def
} def
/Left {
Heading exch sub Trueheading
/Heading exch def
} def
/Trueheading {
360 mod dup
0 lt { 360 add } if
} def
/Forward {
dup  Heading sin mul
exch Heading cos mul
2 copy Newposition
rlineto
} def
/Newposition {
Heading 180 gt Heading 360 lt
and { neg } if exch
Heading  90 gt Heading 270 lt
and { neg } if exch
Ypos add /Ypos exch def
Xpos add /Xpos exch def
} def
/TREE{
/Arg exch def Arg Arg
0
gt
{
10
Forward
/Arg exch def Arg Arg
20
div
Left
/Arg exch def Arg Arg
1
sub
TREE
/Arg exch def }{
10
Forward
5
Left
/Arg exch def } ifelse
} def
/LINE{
/Arg exch def Arg Arg
1
lt
{
10
Forward
60
Left
/Arg exch def }{
50
Right
10
Forward
/Arg exch def Arg Arg
1
sub
LINE
/Arg exch def } ifelse
} def
/KOCH{
/Arg exch def Arg Arg
0
eq
{
5
Forward
/Arg exch def }{
/Arg exch def Arg Arg
1
sub
KOCH
60
Left
/Arg exch def Arg Arg
1
sub
KOCH
120
Right
/Arg exch def Arg Arg
1
sub
KOCH
60
Left
/Arg exch def Arg Arg
1
sub
KOCH
/Arg exch def } ifelse
} def
/BLIP{
/Arg exch def Arg Arg
1
eq
{
3
Forward
/Arg exch def }{
/Arg exch def Arg Arg
1
sub
BLIP
90
Left
/Arg exch def Arg Arg
1
sub
BLIP
/Arg exch def Arg Arg
1
sub
BLIP
90
Right
/Arg exch def Arg Arg
1
sub
BLIP
90
Right
/Arg exch def Arg Arg
1
sub
BLIP
/Arg exch def Arg Arg
1
sub
BLIP
90
Left
/Arg exch def Arg Arg
1
sub
BLIP
/Arg exch def } ifelse
} def
/MAIN{
6
KOCH
} def
Xpos Ypos moveto
MAIN
stroke
showpage
