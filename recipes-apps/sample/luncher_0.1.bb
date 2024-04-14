SUMMARY = "Simple Qt application with QML"
DESCRIPTION = "A basic Qt application that uses QML for the UI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/:"

DEPENDS = "qtbase qtquickcontrols2"

SRC_DIR = "luncher"
SRC_URI = "file://luncher/"

S = "${WORKDIR}/luncher"

inherit  qmake5

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/qml_luncher    ${D}${bindir}
}

FILES:${PN} = "${bindir}/*"
