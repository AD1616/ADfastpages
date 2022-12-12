---
title: Frontend for Lights
layout: default
description: Async fetch of lights data
permalink: /api/lights
tags: [javascript]
---

<div id="data-container"> </div>

<script>
const url = 'http://localhost:8096/api/lights/';

const response = await fetch(url);

const data = await response.json();

const container = document.getElementById('data-container');
container.innerHTML = data;
</script>
