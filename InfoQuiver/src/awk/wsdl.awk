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
	gsub(/<wsdl:types>/, "<import namespace=\"urn:datatypes:sequencer\" location=\"iquiver_torque_om.xsd\"/>\n<import namespace=\"urn:datatypes:sequencer\" location=\"iquiver_util_om.xsd\"/>\n<wsdl:types>\n");
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
