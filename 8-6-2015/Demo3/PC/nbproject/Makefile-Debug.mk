#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=GNU-Linux-x86
CND_DLIB_EXT=so
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/Application.o \
	${OBJECTDIR}/Cache.o \
	${OBJECTDIR}/Conﬁguration.o \
	${OBJECTDIR}/DateAndTime.o \
	${OBJECTDIR}/ExceptionTest.o \
	${OBJECTDIR}/Logging.o \
	${OBJECTDIR}/LoggingConfig.o \
	${OBJECTDIR}/Memory.o \
	${OBJECTDIR}/Mysql.o \
	${OBJECTDIR}/Notiﬁcation.o \
	${OBJECTDIR}/Platform.o \
	${OBJECTDIR}/Process.o \
	${OBJECTDIR}/Random.o \
	${OBJECTDIR}/Server.o \
	${OBJECTDIR}/String.o \
	${OBJECTDIR}/TestLibrary.o \
	${OBJECTDIR}/TestThread.o \
	${OBJECTDIR}/Thread.o \
	${OBJECTDIR}/Type.o \
	${OBJECTDIR}/main.o


# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-lPocoData -lPocoDataMySQL -lPocoDataMySQLd -lPocoDataSQLite -lPocoDataSQLited -lPocoDatad -lPocoFoundation -lPocoFoundationd -lPocoUtil -lPocoUtild -lPocoXML -lPocoXMLd -lPocoZip -lPocoZipd -lPocoCrypto -lPocoCryptod -lPocoData -lPocoDataMySQL -lPocoDataMySQLd -lPocoDataODBC -lPocoDataODBCd -lPocoDataSQLite -lPocoDataSQLited -lPocoDatad -lPocoFoundation -lPocoFoundationd -lPocoJSON -lPocoJSONd -lPocoMongoDB -lPocoMongoDBd -lPocoNet -lPocoNetSSL -lPocoNetSSLd -lPocoNetd -lPocoUtil -lPocoUtild -lPocoXML -lPocoXMLd -lPocoZip -lPocoZipd

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/pc

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/pc: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/pc ${OBJECTFILES} ${LDLIBSOPTIONS}

${OBJECTDIR}/Application.o: Application.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Application.o Application.cpp

${OBJECTDIR}/Cache.o: Cache.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Cache.o Cache.cpp

${OBJECTDIR}/Conﬁguration.o: Conﬁguration.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Conﬁguration.o Conﬁguration.cpp

${OBJECTDIR}/DateAndTime.o: DateAndTime.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/DateAndTime.o DateAndTime.cpp

${OBJECTDIR}/ExceptionTest.o: ExceptionTest.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/ExceptionTest.o ExceptionTest.cpp

${OBJECTDIR}/Logging.o: Logging.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Logging.o Logging.cpp

${OBJECTDIR}/LoggingConfig.o: LoggingConfig.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/LoggingConfig.o LoggingConfig.cpp

${OBJECTDIR}/Memory.o: Memory.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Memory.o Memory.cpp

${OBJECTDIR}/Mysql.o: Mysql.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Mysql.o Mysql.cpp

${OBJECTDIR}/Notiﬁcation.o: Notiﬁcation.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Notiﬁcation.o Notiﬁcation.cpp

${OBJECTDIR}/Platform.o: Platform.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Platform.o Platform.cpp

${OBJECTDIR}/Process.o: Process.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Process.o Process.cpp

${OBJECTDIR}/Random.o: Random.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Random.o Random.cpp

${OBJECTDIR}/Server.o: Server.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Server.o Server.cpp

${OBJECTDIR}/String.o: String.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/String.o String.cpp

${OBJECTDIR}/TestLibrary.o: TestLibrary.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/TestLibrary.o TestLibrary.cpp

${OBJECTDIR}/TestThread.o: TestThread.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/TestThread.o TestThread.cpp

${OBJECTDIR}/Thread.o: Thread.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Thread.o Thread.cpp

${OBJECTDIR}/Type.o: Type.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Type.o Type.cpp

${OBJECTDIR}/main.o: main.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/main.o main.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}
	${RM} ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/pc

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
