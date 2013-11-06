GenericApp
==========

Just a general GWT app based on the reference start application.  Extended slightly to show a number of things:

1.  Seperation of Callback / Handlers
2.  The population, passing and use of serialized objects
     - via the model objects in the "shared" area.
     
//comments are stripped out mostly as I hate them.

Code Structure
|- client            onModuleLoad code
   |- callbacks      code which is executed after a server call
   |- handlers       code which is called after using action
   |- rpc            RPC skeleton and Stubs (contracts)
|- server            Code which is instantiated upon RPC call
|- shared             
   |-model           Classes of Serialisable objects representing the data
   |-validation      Utility to check input
