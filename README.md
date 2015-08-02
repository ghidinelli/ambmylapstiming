AMB MyLaps Timing app
===============

*This is a sample app for AMB Mylaps conversion from binary protocols P3 and P98 into JSON.*
 
The sample code calls server based converter on http://ambconverter.appspot.com that provides JSON API.
The client code builds JSON POST request with binary data and server returns JSON representation of information inside. See unit tests for sample usage.

The servers converter supports decoders with P3 and P98 protocols like AMBrc Decoder, MYLAPS RC4 Decoder, AMBmx3 Decoder, TranX3 Decoder, ChipX Decoder or BIB Decoder. 
The legacy decoders are partly supported as well: AMBrc, AMB20, AMB130, TranX-2 / TranX2, TranXPro, Activ, PegaSys as well. 

Support for the new MyLaps X2 decoder is under development.

There are also 3rd party decoders supporting this protocols, but not listed on this site.

For offline conversion use free conversion utility linked from Maven central repo:

```
 <dependency>
     <groupId>eu.plib</groupId>
     <artifactId>plib</artifactId>
     <version>1.3</version>
 </dependency>
```
or Gradle version:
```
compile 'eu.plib:plib:1.3'
```
For more info see AMM converter site at  http://www.ammconverter.eu

