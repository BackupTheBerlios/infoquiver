#
# AKW-Script to insert idMethod entries in customer db schema
#
#-------------
# Functions
#-------------

#-------------
# BEGIN
#-------------
BEGIN {
}
#-------------
# End of BEGIN
#-------------
#-------------
# SCAN
#-------------

/^[ \t]*<wsdl:types>/{
	gsub(/<wsdl:types>/, "<import namespace=\"urn:datatypes:sequencer\" location=\"SpecialTypes.xsd\"/><wsdl:types>");
}

#----------------
{
	print;
}
#----------------
# End of SCAN
#----------------
#-------------
# END
#-------------
END {
}
#----------------
# End of END
#----------------
