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
/TRIANGLE{
dup
5
gt
{
dup
2
div
TRIANGLE
dup
Forward
120
Right
dup
2
div
TRIANGLE
dup
Forward
120
Right
dup
2
div
TRIANGLE
dup
Forward
120
Right
pop }{
0
Forward
pop } ifelse
} def
/MAIN{
250
TRIANGLE
} def
Xpos Ypos moveto
MAIN
stroke
showpage
