# ================================
# Base image: Latest Ubuntu LTS
# ================================
FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# ================================
# System dependencies
# ================================
RUN apt-get update && apt-get install -y \
    ca-certificates \
    curl \
    wget \
    gnupg \
    unzip \
    git \
    software-properties-common \
    fonts-liberation \
    libx11-6 \
    libxcomposite1 \
    libxdamage1 \
    libxrandr2 \
    libgbm1 \
    libasound2t64 \
    libnss3 \
    libgtk-3-0 \
    libxshmfence1 \
    xdg-utils \
    chromium-browser \
    firefox \
    --no-install-recommends \
    && rm -rf /var/lib/apt/lists/*

# ================================
# Java JDK 21
# ================================
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    && rm -rf /var/lib/apt/lists/*

# ================================
# Jenkins (official repo)
# ================================
RUN curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key \
    | tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null && \
    echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
    https://pkg.jenkins.io/debian-stable binary/ \
    > /etc/apt/sources.list.d/jenkins.list

RUN apt-get update && apt-get install -y \
    jenkins \
    && rm -rf /var/lib/apt/lists/*

# ================================
# Install Chromium
# ================================
RUN apt-get install chromium-browser

# ================================
# Install Firefox
# ================================
RUN apt-get install firefox

# ================================
# Google Chrome (latest stable)
# ================================
#RUN curl -fsSL https://dl.google.com/linux/linux_signing_key.pub \
#    | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
#    echo deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] \
#    http://dl.google.com/linux/chrome/deb/ stable main \
#    > /etc/apt/sources.list.d/google-chrome.list
#
#RUN apt-get update && apt-get install -y \
#    google-chrome-stable \
#    && rm -rf /var/lib/apt/lists/*

# ================================
# Mozilla Firefox (latest, non-snap)
# ================================
#RUN FIREFOX_VERSION=$(curl -s https://product-details.mozilla.org/1.0/firefox_versions.json \
#    | grep -oP '"LATEST_FIREFOX_VERSION":\s*"\K[^"]+') && \
#    wget -q https://download.mozilla.org/?product=firefox-${FIREFOX_VERSION}-ssl\&os=linux64\&lang=en-US \
#    -O /tmp/firefox.tar.bz2 && \
#    tar -xjf /tmp/firefox.tar.bz2 -C /opt && \
#    ln -s /opt/firefox/firefox /usr/bin/firefox && \
#    rm /tmp/firefox.tar.bz2

# ================================
# Jenkins user & workspace
# ================================
USER jenkins
WORKDIR /var/jenkins_home

EXPOSE 8080 50000

# ================================
# Default command
# ================================
CMD ["jenkins"]
