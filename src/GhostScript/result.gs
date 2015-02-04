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
dup
0 
gt
{
10

Forward
dup
20 
div
Left
dup
1
sub
TREE
pop }{
10

Forward
5

Left
pop } ifelse
} def
/LINE{
dup
1 
lt
{
10

Forward
60

Left
pop }{
50

Right
10

Forward
dup
1
sub
LINE
pop } ifelse
} def
/KOCH{
dup
0 
eq
{
5

Forward
pop }{
dup
1
sub
KOCH
60

Left
dup
1
sub
KOCH
120

Right
dup
1
sub
koch
60

Left
dup
1
sub
KOCH
pop } ifelse
} def
/BLIP{
dup
1 
eq
{
3

Forward
pop }{
dup
1
sub
BLIP
90

Left
dup
1
sub
BLIP
dup
1
sub
BLIP
90

Right
dup
1
sub
BLIP
90

Right
dup
1
sub
BLIP
dup
1
sub
BLIP
90

Left
dup
1
sub
BLIP
pop } ifelse
} def
/MAIN{
7
BLIP
} def
Xpos Ypos moveto
MAIN
stroke
showpage
