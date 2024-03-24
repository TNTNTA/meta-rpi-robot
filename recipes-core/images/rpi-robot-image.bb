DESCRIPTION = "core-image-base for rpi robot"
LICENSE = "MIT"

#require recipes-core/images/core-image-base.bb
inherit core-image

IMAGE_FSTYPES = "ext4.xz rpi-sdimg"
SDIMG_ROOTFS_TYPE="ext4.xz"

# enable uart
ENABLE_UART="1"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL +=" \
	openssh-sftp-server \
	sudo \
	python3 \
	python3-pip \
	rpi-gpio \
	raspi-gpio \
	ros-core \
	turtlesim \
        fontconfig \
        ttf-bitstream-vera \
        qtbase \
        qtbase-plugins \
        qtdeclarative \
        qtdeclarative-qmlplugins \
        qtquickcontrols2 \
	luncher \
"

# systemd settings
DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED:append = " sysvinit"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

