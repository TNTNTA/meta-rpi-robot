SUMMARY = "Add VLAN Config For ZKOS SVT"
DESCRIPTION = "Add VLAN Config For ZKOS SVT"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://10-eth0.network \
        file://20-eth0.104.netdev \
        file://30-eth0.104.network \
"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-eth0.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/20-eth0.104.netdev ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/30-eth0.104.network ${D}${sysconfdir}/systemd/network/
}

FILES_${PN} = "${sysconfdir}/systemd/network/*"
