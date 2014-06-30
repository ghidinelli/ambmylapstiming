AMB MyLaps Timing app
===============

*This is a sample app for AMB Mylaps conversion from binary protocols P3 and P98 into JSON.*
 
The sample code calls server based converter on http://ambconverter.appspot.com that provides JSON API.
The client code builds JSON POST request with binary data and server returns JSON representation of information inside. See unit tests for sample usage.

The servers converter supports decoders AMBrc Decoder, MYLAPS RC4 Decoder, AMBmx3 Decoder, TranX3 Decoder, ChipX Decoder or BIB Decoder. 
The legacy decoders are partly supported as well: AMBrc, AMB20, AMB130, TranX-2 / TranX2, TranXPro, Activ, PegaSys as well. 
There are also 3rd party decoders supporting this protocols, but not listed on this site.


For another implemenations of the converter see https://sites.google.com/site/ambmylapstester

