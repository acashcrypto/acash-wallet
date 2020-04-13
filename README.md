# ACASH Wallet

[Download here](https://github.com/acashcrypto/acash-wallet/releases)



Security Warnings
-----------------

**ACASH is experimental and a work-in-progress.** Use at your own risk.



*ACASH Desktop GUI Wallet is based on ZENCash Desktop GUI Wallet*
# [ZENCash](https://zensystem.io/) Desktop GUI Wallet

## Graphical user interface wrapper for the [ZENCash](https://zensystem.io/) command line tools

This program provides a Graphical User Interface (GUI) for the ZENCash client tools that acts as a wrapper and 
presents the information in a user-friendly manner.

#### New/Experimental: [ZENCash Desktop GUI Wallet for Mac OS](https://github.com/ZencashOfficial/zencash-swing-wallet-ui/blob/master/docs/Release_0.73.4.md) is available

#### New/Experimental: [ZENCash Desktop GUI Wallet for Windows](https://github.com/ZencashOfficial/zencash-swing-wallet-ui/blob/master/docs/Release_0.73.1.md) is available


## Building, installing and running the Wallet GUI

Before installing the Desktop GUI Wallet you need to have ZENCash up and running. The following 
[guide](https://github.com/ZencashOfficial/zen/blob/master/README.md) 
explains how to set up [ZENCash](https://zensystem.io/). 

**For security reasons it is recommended to always build the GUI wallet program from GitHub**
**[source](https://github.com/ZencashOfficial/zencash-swing-wallet-ui/archive/master.zip).**
The details of how to build it are described below (easy to follow). 


1. Operating system and tools

   As of June 2017 (ZENCash v1.0.9) this program is mostly tested on Linux and Mac OS X
   (same limitation as [ZENCash](https://zensystem.io/)) with experimental support for Windows.
   The Linux tools you need to build and run the Wallet GUI are Git, Java (JDK7 or later) and
   Ant. If using Ubuntu Linux, they may be installed via command: 
   ```
   user@ubuntu:~/build-dir$ sudo apt-get install git default-jdk ant
   ``` 
   For RedHat/CentOS/Fedora-type Linux systems the command is (like):
   ```
   user@centos:~/build-dir$ sudo yum install java-1.8.0-openjdk git ant 
   ```
   The name of the JDK package (`java-1.8.0-openjdk`) may vary depending on the Linux system, so you need to
   check it, if name `java-1.8.0-openjdk` is not accepted.
   If you have some other Linux distribution, please check your relevant documentation on installing Git, 
   JDK and Ant. The commands `git`, `java`, `javac` and `ant` need to be startable from command line 
   before proceeding with build.

2. Building from source code

   As a start you need to clone the zencash-swing-wallet-ui Git repository:
   ```
   user@ubuntu:~/build-dir$ git clone https://github.com/ZencashOfficial/zencash-swing-wallet-ui.git
   ```
   Change the current directory:
   ```
   user@ubuntu:~/build-dir$ cd zencash-swing-wallet-ui/
   ```
   Issue the build command:
   ```
   user@ubuntu:~/build-dir/zencash-swing-wallet-ui$ ant -buildfile ./src/build/build.xml
   ```
   This takes a few seconds and when it finishes, it builds a JAR file `./build/jars/ZENCashSwingWalletUI.jar`. 
   You need to make this file executable:
   ```
   user@ubuntu:~/build-dir/zencash-swing-wallet-ui$ chmod u+x ./build/jars/ZENCashSwingWalletUI.jar
   ```
   At this point the build process is finished the built GUI wallet program is the JAR 
   file `./build/jars/ZENCashSwingWalletUI.jar`

3. Installing the built ZENCash GUI wallet

   3.1. If you have built ZENCash from source code:

     Assuming you have already built from source code [ZENCash](https://zensystem.io/) in directory `/home/user/zen/src` (for example - this is the typical build dir. for ZENCash v1.0.9) which contains the command line tools `zen-cli` and `zend` you need to take the created file `./build/jars/ZENCashSwingWalletUI.jar` and copy it to directory `/home/user/zen/src` (the same dir. that contains `zen-cli` and `zend`). Example copy command:
      ```
      user@ubuntu:~/build-dir/zencash-swing-wallet-ui$ cp ./build/jars/ZENCashSwingWalletUI.jar /home/user/zen/src    
      ```

4. Running the installed ZENCash GUI wallet

   It may be run from command line or started from another GUI tool (e.g. file manager). 
   Assuming you have already installed [ZENCash](https://zensystem.io/) and the GUI Wallet `ZENCashSwingWalletUI.jar` in 
   directory `/home/user/zen/src` one way to run it from command line is:
   ```
   user@ubuntu:~/build-dir/zencash-swing-wallet-ui$ java -jar /home/user/zen/src/ZENCashSwingWalletUI.jar
   ```
   If you are using Ubuntu (or similar ;) Linux you may instead just use the file manager and 
   right-click on the `ZENCashSwingWalletUI.jar` file and choose the option "Open with OpenJDK 8 Runtime". 
   This will start the ZENCash GUI wallet.
   
   **Important:** the ZENCash configuration file `~/.zen/zen.conf` needs to be correctly set up for the GUI
   wallet to work. Specifically the RPC user and password need to be set in it like:
   ```
   rpcuser=username
   rpcpassword=wjQOHVDQFLwztWp1Ehs09q7gdjHAXjd4E
    
   ``` 


### License
This program is distributed under an [MIT License](https://github.com/ZencashOfficial/zencash-swing-wallet-ui/raw/master/LICENSE).

### Disclaimer

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

### Known issues and limitations

1. Limitation: if two users exchange text messages via the messaging UI TAB and one of them has a system clock, substantially running slow or fast by more than 1 minute, it is possible that this user will see text messages appearing out of order. 
1. Limitation: if a messaging identity has been created (happens on first click on the messaging UI tab), then replacing the `wallet.dat` or changing the node configuration between mainnet and testnet will make the identity invalid. This will result in a wallet update error. To remove the error the directory `~/.ZENCashSwingWalletUI/messaging` may be manually renamed or deleted (when the wallet is stopped). **CAUTION: all messaging history will be lost in this case!**
1. Limitation: Wallet encryption has been temporarily disabled in ZENCash due to stability problems. A corresponding issue 
[#1552](https://github.com/zcash/zcash/issues/1552) has been opened by the ZCash developers. Correspondingly
wallet encryption has been temporarily disabled in the ZENCash Desktop GUI Wallet.
1. Issue: GUI data tables (transactions/addresses etc.) allow copying of data via double click but also allow editing. 
The latter needs to be disabled. 
1. Limitation: The list of transactions does not show all outgoing ones (specifically outgoing Z address 
transactions). A corresponding issue [#1438](https://github.com/zcash/zcash/issues/1438) has been opened 
for the ZCash developers. 
1. Limitation: The CPU percentage shown to be taken by zend on Linux is the average for the entire lifetime 
of the process. This is not very useful. This will be improved in future versions.
1. Limitation: When using a natively compiled wallet version (e.g. `ZENCashSwingWalletUI.exe` for Windows) on a 
very high resolution monitor with a specifically configured DPI scaling (enlargement) factor to make GUI 
elements look larger, the GUI elements of the wallet actually do not scale as expected. To correct this on
Windows you need to right-click on `ZENCashSwingWalletUI.exe` and choose option:
```
Properties >> Compatibility >> Override High DPI scaling behavior >> Scaling Performed by (Application)
```
Example:

![DPI Scaling](https://github.com/ZencashOfficial/zencash-swing-wallet-ui/raw/master/docs/EXEScalingSettings.png "DPI Scaling")
