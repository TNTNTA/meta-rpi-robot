DESCRIPTION = "The goal is to init rpi robot luncher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0"

SRC_URI = " file://rpi-robot-luncher.service \
   		 file://rpi_robot_init.sh \
    "

inherit systemd update-rc.d

SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE_${PN} = "rpi-robot-luncher.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/rpi-robot-luncher.service ${D}${systemd_unitdir}/system
        install -d ${D}${base_sbindir}
        install -m 0755 ${WORKDIR}/rpi_robot_init.sh ${D}${base_sbindir}
    else
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/rpi_robot_init.sh ${D}${sysconfdir}/init.d/
    fi
}

INITSCRIPT_NAME = "rpi_robot_init.sh"

FILES:${PN} = " \
    ${systemd_unitdir}/system/rpi-robot-luncher.service \
    ${base_sbindir}/rpi_robot_init.sh \
    ${sysconfdir}/init.d/rpi_robot_init.sh \
    "

